package uz.alphadroid.solid.SOLID

// LISKOV SUBSTITUTION PRINCIPLE

/**
 * Ushbu printsip SOLID ning L qismiga tegishli joyi xisolanadi.
 * Demak bunda har bir yo`nalish o`z xusuiyatini yo`qotmagan holatda kerakli
 * class yoki interface larga ajratilishi kerak. Masalan Penguin classi bor va u Bird classidan
 * implement qildi va bird classida fly degan funksiya ham bor va u override bo`ldi va bu noqulay
 * vaziyatga olib keldi. Demak buni oldini biz aynan Liskov printsipi
 * bilan hal qilishimiz mumkun. Yechim: Bird degan umumiy class ochiladi va undan tashqari
 * qushlar uchadigan va uchmaydigan turlarga bo`linadi , misol uchun IFBIRDCANFLY deb nomlangan interface
 * ochamiz va tarkibida  fly metodini joylashtiramiz.  Keyin esa biz 2 xil class
 * elon qilamiz bular Penguin va Eagle. Penguin ucha ilmagani sabab faqatgina Bird deb
 * nomlangan class dan voris olib kifoylanadi. Eagle ucha olgani sabab Bird classidan voris
 * olibgina qolmay IFBIRDCANFLY interfeysidan ham implement qiladi chunki
 * burgut ucha oladi. Shunda biz uchbu printsip bilan muammoga yechim topgan bo`lamiz.
 *
 * */

class L {

}

/**
 * VIOLATION BRO
 * */

open  class  Bird{
    open fun fly(){
        // codes
    }
}

class Penguin: Bird(){
    override fun fly() {
        println("Penguins can`t fly !")
    }
}


/**
 * CORRECT BRO
 * */


open class  Bird_1(){

}

interface  IfBirdCanFly{
      fun fly(): Boolean
}


class  Penguin_1 : Bird_1(){
    // some codes
}

class Eagle : Bird_1() , IfBirdCanFly{
    override fun fly(): Boolean {
        return  true
    }

}

/**
 * My approaches fixed by ChatGPT

 * Liskov Substitution Principle (LSP) — SOLID tamoyillarining L harfiga to‘g‘ri keladi.
 * Bu printsip shuni anglatadiki, agar bir sinf boshqa bir sinfning vorisi bo‘lsa (ya'ni subclass bo‘lsa),
 * u ota sinfning o‘rnini to‘liq egallay olishi kerak, xatti-harakat buzilmasligi zarur.
 *
 * Masalan, agar `Bird` sinfida `fly()` metod bo‘lsa va `Penguin` undan meros olsa, lekin ucha olmasa,
 * bu dizayn noto‘g‘ri bo‘ladi. Chunki `Penguin` sinfini `Bird` o‘rniga ishlatganimizda xatolik yuz beradi.
 *
 * Bu muammoni hal qilish uchun `Bird` sinfini umumiy holatda saqlab, uchish funksiyasini
 * alohida interfeysga (`IfBirdCanFly`) ajratamiz. Shunda `Eagle` sinfi `Bird` va `IfBirdCanFly` ni implement qiladi,
 * `Penguin` esa faqat `Bird` sinfidan voris oladi.
 *
 * Bu LSP printsipini to‘g‘ri qo‘llash orqali ortiqcha majburiyliklardan qochamiz va tizimni kengaytirishda muammosiz harakat qilamiz.
 */


