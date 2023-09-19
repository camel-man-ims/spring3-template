package com.camelman.design_pattern.chap2_creational_pattern

// Product
interface Shape {
    fun draw()
}

// ConcreteProduct A
class Circle : Shape {
    override fun draw() {
        println("Drawing Circle")
    }
}

// ConcreteProduct B
class Rectangle : Shape {
    override fun draw() {
        println("Drawing Rectangle")
    }
}

// Creator
abstract class ShapeFactory {
    abstract fun createShape(): Shape
}

// ConcreteCreator A
class CircleFactory : ShapeFactory() {
    override fun createShape(): Shape {
        return Circle()
    }
}

// ConcreteCreator B
class RectangleFactory : ShapeFactory() {
    override fun createShape(): Shape {
        return Rectangle()
    }
}

fun main() {
    // Create factory objects
    val circleFactory = CircleFactory()
    val rectangleFactory = RectangleFactory()

    // Create shapes using factory method
    val circle = circleFactory.createShape()
    val rectangle = rectangleFactory.createShape()

    // Use the shapes
    circle.draw()
    rectangle.draw()
}
