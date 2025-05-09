package uz.alphadroid.solid.SOLID


// SINGLE RESPONSIBILITY PRINCIPLE

/**
 *  Ushbu printsip solidning birinchi printsipi bo`lib yagona javobgarlik
 *  degan ma`noni bildiradi. Buni quyidagicha tushuntirib o`taman : Har bir vazifa uchun alohida
 *  modullarga  ajratish shart va zarur xisoblanadi. Masalan maqsadli bir xil tipdagi funksiyalar uchun
 *  alohida class lar ochish nazarda tutilgan.
 *
 *  Misol uchun bizda bitta "SystemManager" degan class mavjud va unda user qo`shish , o`chirish ,
 *  notification yuborish kabi funksiyalar mavjud. Biz buni ushbu printsipga moslasak
 *  biz ushbu class ni  2 ga ajratishimiz kerak bo`ladi , bular "UserManager" va "NotificationManager"
 *  deb nomlanishi kerak. shunda birinchi class ga user bilan bog`liq bo`lgan
 *  xisob- kitob funsiyalari joylashtiriladi. NotificationManager classida esa faqat notification
 *  ga bog`liq bo`lgan funksiyalar kiritiladi.
 * */

class S {
    var obj = SystemManager()



    fun doSomething(){
        println( obj.addUser(User(0, "Ali", "998889988")))
        println(UserManager().addUser(User(1,"Vali","778889977")))
    }



}

fun main() {
    var s= S()
    println(s.doSomething())
}


/**
 * VIOLATION BRO
 * */

class SystemManager(){
    fun addUser(user: User){}
    fun deleteUser(user: User){}
    fun sendEmail(user: User , email :String){}
    fun notification(notifyMessage: String){}
}


data class User(var id: Int , var fullName: String , var phoneNumber: String)


/**
 * CORRECT USAGE BRO
 * */


class  MailManager{
    fun sendEmail(user: User , email :String){}
}

class  UserManager{
    fun addUser(user: User){}
    fun deleteUser(user: User){}
}

class  NotificationManager{
    fun notification(notifyMessage: String){}
}


/**
 * My approaches fixed by ChatGPT

 * Single Responsibility Principle (SRP) — bu SOLID tamoyillarining birinchi printsipi bo‘lib,
 * har bir class yoki modul faqat bitta vazifaga javobgar bo‘lishi kerakligini bildiradi.
 *
 * Har qanday sinf faqat bitta sababga ko‘ra o‘zgartirilishi kerak.
 * Agar sinf bir nechta vazifani bajarsa (masalan: foydalanuvchi boshqaruvi, email jo‘natish, bildirishnoma),
 * bu holatda u turli sabablar bilan o‘zgartirilishga majbur bo‘ladi — bu SRP’ni buzadi.
 *
 * Masalan, `SystemManager` sinfi foydalanuvchi qo‘shish, o‘chirish, email yuborish, va xabar jo‘natishni bajaradi.
 * Bu SRP printsipiga zid. To‘g‘ri yechim — bu vazifalarni alohida sinflarga ajratish:
 * - `UserManager`: foydalanuvchiga oid amallar
 * - `MailManager`: email yuborish
 * - `NotificationManager`: xabar jo‘natish
 *
 * Shu tarzda, har bir class bitta vazifani bajaradi va faqat o‘sha masalaga javobgar bo‘ladi.
 */




