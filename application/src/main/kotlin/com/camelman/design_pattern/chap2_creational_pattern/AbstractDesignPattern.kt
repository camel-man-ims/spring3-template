package com.camelman.design_pattern.chap2_creational_pattern

// Abstract Products
interface Button {
    fun render()
}

interface Checkbox {
    fun render()
}

// Concrete Products
class WindowsButton : Button {
    override fun render() = println("WindowsButton rendered")
}

class MacOSButton : Button {
    override fun render() = println("MacOSButton rendered")
}

class WindowsCheckbox : Checkbox {
    override fun render() = println("WindowsCheckbox rendered")
}

class MacOSCheckbox : Checkbox {
    override fun render() = println("MacOSCheckbox rendered")
}

// Abstract Factory
interface UIAbstractFactory {
    fun createButton(): Button
    fun createCheckbox(): Checkbox
}

// Concrete Factories
class WindowsUIFactory : UIAbstractFactory {
    override fun createButton() = WindowsButton()
    override fun createCheckbox() = WindowsCheckbox()
}

class MacOSUIFactory : UIAbstractFactory {
    override fun createButton() = MacOSButton()
    override fun createCheckbox() = MacOSCheckbox()
}

// Client Code
fun main() {
    val factory: UIAbstractFactory = WindowsUIFactory()
    val button = factory.createButton()
    val checkbox = factory.createCheckbox()

    button.render()
    checkbox.render()
}
