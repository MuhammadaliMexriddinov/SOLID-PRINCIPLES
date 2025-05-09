package uz.alphadroid.solid.SOLID


// OPEN CLOSED PRINCIPLE

/**
 * Ushbu printsip SOLID ning ikkinchi "O" qismiga tegishli joyi xisoblanadi.
 * Ochiq yopiqlilik printsipi. Bunda class yoki class tarkibidagi funksiya kengaytirish
 * uchun ochiq va o`zgartirish uchun yopiq degan ma`noni bildiradi.
 * Tushuntirib o`tsak : bir calculateArea funksiyasi parametr sifatida
 * Shape class objectini qabul qilsin va aynan shu funksiya shakl turiga
 * ko`ra bir necha xil turlarga ajratilgan bo`lsa bunda funksiya tanasida
 * o`zgarishlar sodir bo`ladi (maslan Aylana yoki To`rtburchak) ushbu holatda funksiya o`zgaryapti
 * if else larga ko`ra va bunda SOLID O bajarilmadi. Buni bajarish
 * maqsadida Shape deb nomlangan interfeys ochib tarkibida area degan funksiya ochib qo`yilsin.
 * shunda kerakli Rectangle yoki Circle class kerakli tarzda Shape interfeysidan implement qilinishi
 * mumkun (xohishga ko`ra) va bu har bir class alohida kengaytirildi (o`zgartirilmadi !)
 * Ushbu printsipda aynan shu nazarda tutilgan.
 *
 * */

class O {

}

/**
 * VIOLATION BRO
 * */

class Shape(val type: String, val width: Double, val height: Double)

fun calculateArea(shape: Shape): Double {
    if (shape.type == "rectangle") {
        return shape.width * shape.height
    } else if (shape.type == "circle") {
        return Math.PI * shape.width * shape.width
    }
    return 0.0
}


/**
 * CORRECT BRO
 * */

interface Shape_1 {
    fun area(): Double
}

class  Rectangle (val height :Double , val with :Double):Shape_1{
    override fun area()= height*with
}

class Circle(val radius: Double):Shape_1{
    override fun area(): Double {
        return Math.PI*radius*radius
    }

}

fun calculateArea(shape:Shape_1)= shape.area()

/**
 * My approaches fixed by ChatGPT
 * Open/Closed Principle (OCP) — bu SOLID tamoyillarining "O" harfiga tegishli bo‘lib,
 * u klasslar va funksiyalar kengaytirish (extension) uchun ochiq,
 * lekin o‘zgartirish (modification) uchun yopiq bo‘lishi kerakligini bildiradi.
 *
 * Masalan, `calculateArea()` funksiyasida `Shape` turiga qarab if-else bloklari bilan
 * turli shakllar (aylana, to‘rtburchak) uchun maydon hisoblanadi.
 * Har safar yangi shakl qo‘shilganda, mavjud funksiyani o‘zgartirishga to‘g‘ri keladi — bu OCP’ni buzadi.
 *
 * Buni to‘g‘rilash uchun `Shape` nomli interfeys ochiladi va `area()` metodini belgilaydi.
 * Har bir shakl (masalan, `Rectangle`, `Circle`) shu interfeysni implement qiladi.
 * Endi `calculateArea()` funksiyasi bir xil qoladi — faqat yangi shakllar klass sifatida qo‘shiladi.
 * Kod kengaymoqda, lekin mavjud kod o‘zgarmayapti — bu esa OCP printsipiga to‘liq mos tushadi.
*/









