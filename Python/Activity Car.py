class Car:

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " + self.model + " moving")

    def stop(self):
        print(self.manufacturer + " " + self.model + " stopped")

car1 = Car("Tata", "Indica", "2018", "Manual", "White")


car1.accelerate()
car1.stop()