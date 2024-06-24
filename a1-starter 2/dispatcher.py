"""Dispatcher for the simulation"""

from typing import Optional
from driver import Driver
from rider import Rider


class Dispatcher:
    """A dispatcher fulfills requests from riders and drivers for a
    ride-sharing service.
    When a rider requests a driver, the dispatcher assigns a driver to the
    rider. If no driver is available, the rider is placed on a waiting
    list for the next available driver. A rider that has not yet been
    picked up by a driver may cancel their request.
    When a driver requests a rider, the dispatcher assigns a rider from
    the waiting list to the driver. If there is no rider on the waiting list
    the dispatcher does nothing. Once a driver requests a rider, the driver
    is registered with the dispatcher, and will be used to fulfill future
    rider requests.
    """
    all_drivers: list
    wait_list: list

    def __init__(self) -> None:
        """Initialize a Dispatcher.
        """
        self.all_drivers = []
        self.wait_list = []

    def __str__(self) -> str:
        """Return a string representation.
        """
        return f"{self.all_drivers}, {self.wait_list}"

    def generate_ava_driver(self) -> list:
        """
        return a list of drivers in all drivers that are idle
        """
        available_driver = []

        for driver in self.all_drivers:
            if driver.is_idle:
                available_driver.append(driver)

        return available_driver

    def request_driver(self, rider: Rider) -> Optional[Driver]:
        """Return a driver for the rider, or None if no driver is available.
        Add the rider to the waiting list if there is no available driver.
        """
        if self.all_drivers != []:

            available_driver = self.generate_ava_driver()

            if available_driver == []:
                self.wait_list.append(rider)
                return None

            else:
                return _find_min_driver(available_driver, rider)

        else:
            self.wait_list.append(rider)
            return None

    def request_rider(self, driver: Driver) -> Optional[Rider]:
        """Return a rider for the driver, or None if no rider is available.
        If this is a new driver, register the driver for future rider requests.
        """
        if driver not in self.all_drivers:
            self.all_drivers.append(driver)

        if self.wait_list:
            longest_waiter = self.wait_list[0]
            self.wait_list.pop(0)
            return longest_waiter

        else:
            return None

    def cancel_ride(self, rider: Rider) -> None:
        """Cancel the ride for rider.
        """
        if rider in self.wait_list:
            self.wait_list.remove(rider)
        rider.status_update('c')


def _find_min_driver(available_driver: list, rider: Rider) -> Driver:
    """
    find the driver closest to the rider from a list of available drivers
    """
    min_time_driver = available_driver[0]
    for driver in available_driver:
        if driver.get_travel_time(rider.origin) < \
                min_time_driver.get_travel_time(rider.origin):
            min_time_driver = driver

    return min_time_driver


if __name__ == '__main__':
    import python_ta
    python_ta.check_all(config={'extra-imports': ['typing', 'driver', 'rider']})
