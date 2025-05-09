package uz.alphadroid.solid.SOLID


// DEPENDENCY INVERSION

/**
 * Ushbu printsip SOLID ning D qismigqa tegishli joyi xisoblanadi.
 * Bunda biz Modullar orasidagi bog‘liqlikni abstraksiyalarga asoslab qurishni
 * tushunishimiz kerak. Misol uchun namuna sifatida  saveData funksiyasida
 * buni ko`rib chiqsak. Database ga ma`lumotni saqlashda biz interface yoki abstract class
 * orqali mavhumlikni saqlashimiz ya`ni saveData funksiyasini interface
 * ga  olib chiqib taminlashimiz mumkun. Shunda har bir databse ga ma`lumot saqlayotganda
 *  ushbu interface dan implement qilib malumotni save qilishimiz mumkun.
 *  Umuman olganda Dependency inversionni oldini dependency injection orqali olishimiz mumkun
 *  bundi DI android uchun Dagger , Dagger Hilt , Dagger 2 , Koin kabi imkoniyatlarni sanab
 *  o`tishimiz mumkun.
 *
 * */

class D {

}

/**
 * VIOLATION BRO
 * */

class MySQLDatabase{
    fun saveData(data: String){
        println("saved $data")
    }
}

class DataManager{
    private  val database = MySQLDatabase()

    fun saveData(data:String)
    {
        database.saveData(data)
    }
}




/**
 * CORRECT BRO
 * */


interface  DatabaseCore{
    fun saveData(data:String)
}

class  DB1: DatabaseCore{
    override fun saveData(data: String) {
        println(data)
    }

}

class  DB2: DatabaseCore{
    override fun saveData(data: String) {
        println(data)
    }

}

class  DB3(private  val database : DatabaseCore){
   fun save(data: String){
       database.saveData(data)
   }

}

fun main() {
    val mySQL = DB1()
    val dataManager1 = DB3(mySQL)
    dataManager1.save("Hello from MySQL")

}

/**
 * My approaches fixed by ChatGPT
 *
 * Dependency Inversion Principle (DIP) — bu yuqori darajadagi modullar pastki darajadagilarga emas,
 * balki ularning abstraksiyalariga (interface yoki abstract class) bog‘lanishi kerakligini bildiradi.
 * Misol sifatida, saveData funksiyasini har xil ma’lumotlar bazalariga bog‘lamaslik uchun uni
 * DatabaseCore nomli interface orqali ajratamiz. Har bir turdagi baza (MySQL, Room, Firebase) shu
 * interfeysni implement qiladi. Shunda biz qaysi bazani ishlatishimizdan qat’i nazar, DataManager
 * bir xil interfeys orqali ishlayveradi.
 * Ushbu printsipni real ilovalarda qo‘llashda, ko‘pincha Dependency Injection (DI) texnikasidan
 * foydalaniladi. DI yordamida kerakli implementatsiyalarni tashqaridan uzatamiz va modullar
 * orasidagi bog‘liqlikni kamaytiramiz. Android platformasida Dagger, Dagger Hilt, Koin kabi DI
 * vositalari bu printsipni amaliyotda bajarishga xizmat qiladi.
 * */