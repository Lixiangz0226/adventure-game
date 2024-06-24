
"""
The rider module contains the Rider class. It also contains
constants that represent the status of the rider.
=== Constants ===
WAITING: A constant used for the waiting rider status.
CANCELLED: A constant used for the cancelled rider status.
SATISFIED: A constant used for the satisfied rider status
"""

from location import Location

WAITING = "waiting"
CANCELLED = "cancelled"
SATISFIED = "satisfied"


class Rider:

    """A rider for a ride-sharing service.
    """
    identifier: str
    patience: int
    origin: Location
    destination: Location
    status: str

    def __init__(self, identifier: str, patience: int, origin: Location,
                 destination: Location) -> None:
        """Initialize a Rider.
        >>> r = Rider('Bob', 9, Location(12, 3), Location(5,10))
        >>> r.identifier
        'Bob'
        >>> print(r.origin)
        (12, 3)
        """
        self.identifier = identifier
        self.patience = patience
        self.origin = origin
        self.destination = destination
        self.status = WAITING

    def __str__(self) -> str:
        """Return a string representation of Rider
        >>> r = Rider('Bob', 9, Location(12, 3), Location(5,10))
        >>> print(r)
        Bob, 9, (12, 3), (5, 10), waiting
        """
        return f"{self.identifier}, {self.patience}, {self.origin}, " \
               f"{self.destination}, {self.status}"

    def status_update(self, status: str) -> None:
        """Update the current status of the rider.
        >>> r = Rider('Bob', 9, Location(12, 3), Location(5,10))
        >>> r.status_update('s')
        >>> print(r.status)
        satisfied
        >>> r2 = Rider('John', 11, Location(2, 33), Location(7,6))
        >>> r2.status_update('c')
        >>> print(r2.status)
        cancelled
        """
        if status == 's':
            self.status = SATISFIED

        elif status == 'w':
            self.status = WAITING

        elif status == 'c':
            self.status = CANCELLED

        else:
            raise AttributeError


if __name__ == '__main__':
    import python_ta
    python_ta.check_all(config={'extra-imports': ['location']})
