package uz.alphadroid.solid.SOLID

// INTERFACE SEGREGATION PRINCIPLE

/**
 * Ushbu printsip SOLID ning I qismiga tegishli joyi xisoblanadi.
 * Bunda har bir class o`ziga tegishli interfeysdan implement qilib
 * kengaytirilishi va Sinflar o‘ziga kerak bo‘lmagan funksiyalarni implement qilmasligi.
 * Misol tariqasida Animal classi tarkibida
 * fly hamda swim metodlaro bor va Penguon va Eagle uchun bir xil voris olsak
 * penguin uchun fly , eagle uchun swim funksiyalari mos tushmaydi. Demak ushbu  printsip
 * yordamida bunga yechim bor , bu swim hamda fly degan alohida interfeyslar ochish
 * va kerakli hayvon uchun o`ziga mos interfeysni implement qilish deganidir.
 * */

class I {

}

/**
 * VIOLATION BRO
 * */

interface Animal {
    fun swim()
    fun fly()
}

class  Penguin_I: Animal{
    override fun swim() {
        println("Penguin is swimming now !!!")
    }

    override fun fly() {
       println("Penguin can not fly !")
    }

}

class  Eagle_I: Animal{
    override fun swim() {
        println("eagle can not swim !")
    }

    override fun fly() {
       println("Eagle is flying now !")
    }

}


/**
 * CORRECT BRO
 * */

interface CanSwim{
    fun swim()
}
interface CanFly{
    fun fly()
}

class  Penguin_I_1: CanSwim{
    override fun swim() {
        println("swimming")
    }

}

class  Eagle_I_1: CanFly{
    override fun fly() {
      println("flying")
    }

}

/**
 * My approaches fixed by ChatGPT
 * Interface Segregation Principle (ISP) – bu SOLID tamoyillarining I (Interface Segregation) qismini tashkil qiladi.
 * Bu printsipga ko‘ra, sinflar ularga kerak bo‘lmagan metodlarni o‘z ichiga olgan yirik interfeyslarni implement qilmasligi kerak.
 * Masalan, bitta `Animal` interfeysida `fly()` va `swim()` metodlari mavjud bo‘lsa,
 * `Penguin` ushbu interfeysni implement qilganda `fly()` metodini majburan o‘z ichiga oladi, lekin bu unga tegishli emas.
 * Bu esa Interface Segregation printsipini buzadi.
 * Bu muammoning yechimi — har bir xatti-harakat (fly, swim) uchun alohida interfeys yaratish
 * va kerakli sinflarga faqat o‘sha mos interfeyslarni implement qilish orqali yechim topiladi.
 */