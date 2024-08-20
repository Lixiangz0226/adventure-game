package data_access;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.CompletableFuture;

public class ConvertTextToSpeech {

    private static final String KEY = "AIzaSyCHDZWVTfCV4eMr_raWBFa101vK8CUhTCw";
    private static final String ENDPOINT = "https://texttospeech.googleapis.com/v1/text:synthesize?key=" + KEY;

    /**
     * Turns the given text into a speech MP3 file.
     *
     * @param text The text to be converted to speech.
     */
    public CompletableFuture<String> synthesizeTextToFileAsync(String text) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Create request body
                String requestBody = "{"
                        + "\"input\": {\"text\": \"" + escapeJson(text) + "\"},"
                        + "\"voice\": {"
                        + "\"languageCode\": \"en-US\","
                        + "\"ssmlGender\": \"NEUTRAL\""
                        + "},"
                        + "\"audioConfig\": {\"audioEncoding\": \"MP3\"}"
                        + "}";

                // Set up the HTTP connection
                URI uri = new URI(ENDPOINT);
                URL url = uri.toURL();
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json; utf-8");
                connection.setRequestProperty("Accept", "application/json");
                connection.setDoOutput(true);

                // Write the request body
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = requestBody.getBytes(StandardCharsets.UTF_8);
                    os.write(input);
                }

                // Check for HTTP response code
                int responseCode = connection.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getErrorStream(), StandardCharsets.UTF_8))) {
                        StringBuilder errorBuilder = new StringBuilder();
                        String errorLine;
                        while ((errorLine = br.readLine()) != null) {
                            errorBuilder.append(errorLine.trim());
                        }
                        throw new RuntimeException("HTTP error code: " + responseCode + ", " + errorBuilder.toString());
                    }
                }

                // Read the response
                String response;
                try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                    StringBuilder responseBuilder = new StringBuilder();
                    String responseLine;
                    while ((responseLine = br.readLine()) != null) {
                        responseBuilder.append(responseLine.trim());
                    }
                    response = responseBuilder.toString();
                }

                // Extract the audio content from the JSON response
                String audioContentBase64 = extractJsonValue(response, "audioContent");
                if (audioContentBase64 == null) {
                    throw new RuntimeException("Failed to extract audio content from response");
                }

                byte[] audioContent = Base64.getDecoder().decode(audioContentBase64);

                // For caching purposes
                String fileName = "output_" + text.hashCode() + ".mp3";
                File outputFile = new File(fileName);

                // Write the audio content to a file
                try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                    fos.write(audioContent);
                }

                return outputFile.getAbsolutePath();

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        });
    }

    /**
     * Escapes special characters in a string for inclusion in a JSON string.
     *
     * @param value The string to escape.
     * @return The escaped string.
     */
    private String escapeJson(String value) {
        return value.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\b", "\\b")
                .replace("\f", "\\f")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    /**
     * Extracts a value from a JSON string based on a key.
     *
     * @param json The JSON string.
     * @param key The key to search for.
     * @return The value associated with the key or null.
     */
    private String extractJsonValue(String json, String key) {
        String keyPattern = "\"" + key + "\":\"";
        int startIndex = json.indexOf(keyPattern);
        if (startIndex == -1) return null;

        startIndex += keyPattern.length();
        int endIndex = json.indexOf("\"", startIndex);
        if (endIndex == -1) return null;

        return json.substring(startIndex, endIndex);
    }
}
