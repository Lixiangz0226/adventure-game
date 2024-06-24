"""Locations for the simulation"""

from __future__ import annotations


class Location:
    """A two-dimensional location."""
    row: int
    column: int

    def __init__(self, row: int, column: int) -> None:
        """Initialize a location.
        >>> l1 = Location(6, 12)
        >>> l1.row
        6
        >>> l2 = Location(4, 7)
        >>> l2.column
        7
        """
        self.row = row
        self.column = column

    def __str__(self) -> str:
        """Return a string representation.
        >>> l1 = Location(4, 15)
        >>> print(l1)
        (4, 15)
        >>> l2 = Location (3, 9)
        >>> print(l2)
        (3, 9)
        """
        return f"({self.row}, {self.column})"

    def __eq__(self, other: Location) -> bool:
        """Return True if self equals other, and false otherwise.
        >>> l1 = Location(4, 6)
        >>> l2 = Location(7, 9)
        >>> l1 == l2
        False
        >>> l3 = Location(7, 9)
        >>> l3 == l2
        True
        """
        if not isinstance(other, Location):
            raise TypeError

        return self.row == other.row and self.column == other.column


def manhattan_distance(origin: Location, destination: Location) -> int:
    """Return the Manhattan distance between the origin and the destination.
    >>> l1 = Location(8, 4)
    >>> l2 = Location(16, 9)
    >>> l3 = Location(3, 77)
    >>> manhattan_distance(l1, l2)
    13
    >>> manhattan_distance(l2, l3)
    81
    >>> manhattan_distance(l1, l3)
    78
    """
    total_horizontal = abs(origin.row - destination.row)
    total_vertical = abs(origin.column - destination.column)
    return total_horizontal + total_vertical


def deserialize_location(location_str: str) -> Location:
    """Deserialize a location.
    location_str: A location in the format 'row,col'
    >>> serial_1 = "16, 4"
    >>> print(deserialize_location(serial_1))
    (16, 4)
    >>> serial_2 = "4, 78"
    >>> print(deserialize_location(serial_2))
    (4, 78)
    """
    holder = location_str.split(',')
    return Location(int(holder[0]), int(holder[1]))


if __name__ == '__main__':
    import python_ta
    python_ta.check_all()
