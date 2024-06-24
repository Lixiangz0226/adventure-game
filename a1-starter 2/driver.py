"""Drivers for the simulation"""
from typing import Optional
from location import Location, manhattan_distance
from rider import Rider


class Driver:
    """A driver for a ride-sharing service.
    === Attributes ===
    id: A unique identifier for the driver.
    location: The current location of the driver.
    is_idle: True if the driver is idle and False otherwise.
    """

    id: str
    location: Location
    is_idle: bool
    speed: int
    destination: Optional[Location]

    def __init__(self, identifier: str, location: Location, speed: int) -> None:
        """Initialize a Driver.
        >>> d = Driver("KP20", Location(4, 12), 3)
        >>> d.is_idle
        True
        >>> d.id
        'KP20'
        >>> d2 = Driver("K22", Location(3, 19), 2)
        >>> d2.speed
        2
        >>> print(d.location)
        (4, 12)
        """
        self.id = identifier
        self.location = location
        self.speed = speed
        self.destination = None
        self.is_idle = True

    def __str__(self) -> str:
        """Return a string representation.
        >>> d = Driver("33ED", Location(12, 5), 5)
        >>> print(d)
        33ED, (12, 5), 5
        """
        return f"{self.id}, {self.location}, {self.speed}"

    def __eq__(self, other: object) -> bool:
        """Return True if self equals other, and false otherwise.
        >>> d = Driver("JQ211", Location(3, 8), 4)
        >>> d2 = Driver("JQ211", Location(2, 5), 3)
        >>> d == d2
        True
        """
        return self.id == other.id

    def get_travel_time(self, destination: Location) -> int:
        """Return the time it will take to arrive at the destination,
        rounded to the nearest integer.
        >>> r = Rider("PO44", 2, Location(12, 4), Location(5, 7))
        >>> d = Driver("TR100", Location(7, 4), 2)
        >>> d.get_travel_time(r.origin)
        2
        """
        return round(manhattan_distance(self.location, destination)
                     / self.speed)

    def start_drive(self, location: Location) -> int:
        """Start driving to the location.
        Return the time that the drive will take.
        >>> r = Rider("F400", 3, Location(11, 2), Location(3, 14))
        >>> d = Driver("BI65", Location(5, 2), 3)
        >>> d.start_drive(r.origin)
        2
        >>> print(d.destination)
        (11, 2)
        """
        self.is_idle = False
        self.destination = location
        return self.get_travel_time(location)

    def end_drive(self) -> None:
        """End the drive and arrive at the destination.
        Precondition: self.destination is not None.
        >>> r = Rider("PIL3", 2, Location(3, 2), Location(4, 19))
        >>> d = Driver("TR100", Location(5, 12), 3)
        >>> d.start_drive(r.origin)
        4
        >>> d.end_drive()
        >>> print(d.location)
        (3, 2)
        """
        self.location = self.destination
        self.is_idle = True
        self.destination = None

    def start_ride(self, rider: Rider) -> int:
        """Start a ride and return the time the ride will take.
        >>> r = Rider("FR32", 2, Location(2, 5), Location(20, 16))
        >>> d = Driver("T500", Location(3, 7), 1)
        >>> d.start_drive(r.origin)
        3
        >>> d.end_drive()
        >>> d.start_ride(r)
        29
        """
        self.is_idle = False
        self.destination = rider.destination
        return round(manhattan_distance(rider.origin,
                                        rider.destination) / self.speed)

    def end_ride(self) -> None:
        """End the current ride, and arrive at the rider's destination.
        Precondition: The driver has a rider.
        Precondition: self.destination is not None.
        >>> r = Rider("T200", 5, Location(33, 12), Location(4, 16))
        >>> d = Driver("BR556", Location(4, 12), 2)
        >>> d.start_drive(r.origin)
        14
        >>> d.end_drive()
        >>> d.start_ride(r)
        16
        >>> d.end_ride()
        >>> print(d.location)
        (4, 16)
        """
        self.location = self.destination
        self.is_idle = True
        self.destination = None


if __name__ == '__main__':
    import python_ta
    python_ta.check_all(
        config={'extra-imports': ['location', 'rider']})
