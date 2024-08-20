package entities.map_objects;

import data_access.ConvertTextToSpeech;
import java.util.concurrent.CompletableFuture;

public class TextToSpeechUseCase {
    private ConvertTextToSpeech ttsService;

    public TextToSpeechUseCase(ConvertTextToSpeech ttsService) {
        this.ttsService = ttsService;
    }

    public CompletableFuture<String> convertTextToSpeech(String text) {
        return ttsService.synthesizeTextToFileAsync(text);
    }
}

