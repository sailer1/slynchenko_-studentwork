fun main() {
    var philips = coffemachin();
    philips.start();
}

public class coffemachin() {
    private var status_coffemachine = true;
    private var clear = 10; private var milk = 1000; private var water = 3000; private var coffe = 1000;

    fun start() {
        println("Добро Пожаловать в программу Кофемашина\n_________\nДля продолжения нажмите enter")
        readLine();
        println("Статус кофемашины выключен\nДля включения нажмите 1\nДля выключения нажмите 2")
        var pressing = readLine();
        while (pressing != "1" || pressing != "2") {      // цикл пока не будет 1 или 2
            when (pressing) {
                "1" -> {
                    println("Кофемашина включена\n")
                    status_coffemachine = true;
                    selection_menu();
                }
                "2" -> {
                    println("Кофемашина выключена\n")
                    status_coffemachine = false;
                    return
                }
                else -> {
                        println("Неверная комадна, нажмите от 1 до 2")
                        pressing = readLine()
                    }
                }
            }
    }

    private fun selection_menu() {
                println("Выберите дальнейшие действия:")
                println("\n1. Приготовить кофе" +
                        "\n2. Посмотреть количество индигриентов кофемашины" +
                        "\n3. Проверить сколько кружек кофе до чистки" +
                        "\n4. Выйти из приложения")
        var pressing = readLine();
            while (pressing != "1"||pressing != "2"||pressing != "3"||pressing != "4") {
    when (pressing) {
        "1" -> cook_coffe()
        "2" -> quantity_of_ingredients()
        "3" -> clear()
        "4" -> exit();
        else -> {
            println("Неверная команда, попробуйте снова\n Нажмите от 1 до 4 в зависимости что хотите")
            pressing = readLine();
                }
            }
        }
    }

    private fun cook_coffe() {
        println("Выберите кофе\n1. Капучино\n2. Экспрессо\n3. Сделать свой кофе\n4. Назад в меню")
        if (clear >= 0) {
            val pressing = readLine();
            when (pressing) {
                "1" -> {
                    println("Затраты на капучино\nМолока:100\nКофе:10\nВоды:250\nНажмите enter для продолжения")
                    readLine()
                    checking_for(); //Проверка на количество индигриентов
                    milk -= 100;coffe -= 10;water -= 250;clear--;
                    println("Капучино готов")
                    selection_menu();
                }
                "2" -> {
                    println("Затраты на экспрессо\nМолока:0\nКофе:30\nВоды:250\nНажмите enter для продолжения")
                    readLine()
                    checking_for();
                    coffe -= 30;water -= 250;clear--
                    println("Экспрессо готов")
                    selection_menu();
                }
                "3" -> my_own_coffee()
                "4" -> selection_menu()
            }
        } else {
            println("Производиться чистка. Ожидайте\n_______________________________")
            clear = 10;
            selection_menu();
        }
    }


    private fun quantity_of_ingredients() {
        println(
            "КОЛИЧЕСТВО ИНДИГРИЕНТОВ МАШИНЫ:" +
                    "\nКофе: $coffe" +
                    "\nМолока :$milk " +
                    "\nВоды :$water"
        )
        println("Нажмите любую клавишу для продожения")
        readLine();
        selection_menu();
    }

    private fun clear() {
        println("До чистки осталось <$clear> кружек кофе\n_______________________")
        readLine()
        selection_menu();
    }

    private fun exit() {
        return;
    }

    private fun my_own_coffee() {
        println("Выберите количество индигриентов\n\t Кофе:\n1. 10 гр\n2. 30 гр\n3. 50 гр")
        if (clear >= 0) {
                var pressing = readLine()
                when (pressing) {
                    "1" -> {checking_for(); coffe -= 10}
                    "2" -> { checking_for();coffe -= 30}
                    "3" -> {checking_for();coffe -= 50 }
                    else -> {
                        println("Нажмите от 1 до 3")
                    }
                }
            println("Молоко:\n1. 50 гр\n2. 100 гр\n3. 150 гр")
                val pressing2 = readLine()
                when (pressing2) {
                    "1" -> { checking_for();milk -= 50 }
                    "2" -> { checking_for();milk -= 100 }
                    "3" -> { checking_for();milk -= 150 }
                    else -> { println("Нажмите от 1 до 3") }
                }
            println("Размер стакана:\n1. воды 150 гр\n2. воды 200 гр\n3. воды 250 гр")
                val pressing3 = readLine()
                when (pressing3) {
                    "1" -> { checking_for();water -= 150 }
                    "2" -> { checking_for();water -= 200 }
                    "3" -> { checking_for();water -= 250 }
                    else -> { println("Нажмите от 1 до 3") }
                }
        }else { println("Производиться чистка. Ожидайте\n_______________________________")
            clear = 10;
            selection_menu();
        }
        println("Ваш кофе готов\n Нажмите enter для продолжения")
        clear--;
        readLine();
        selection_menu();
    }

    private fun checking_for() {
        if (water <= 0) {
            println("Недостаточно воды\nНажмите на любую клавишу чтобы налить воды")
            readLine()
            println("Сколько воды налить? от 1 до 3000")

            println("Количество воды:  $water мл")
            readLine()
            selection_menu();
        } else if (milk <= 0) {
            println("Недостаточно молока\nНажмите на любую клавишу чтобы налить молока")
            readLine()
            milk = 1000;
            println("Количество молока:  $milk мл")
            readLine()
            selection_menu();
        }else if (coffe <= 0) {
            println("Недостаточно кофе\nНажмите на любую клавишу чтобы досыпать кофе")
            readLine()
            coffe = 1000;
            println("Количество кофе:  $coffe гр")
            readLine()
            selection_menu();
        }
    }
}

