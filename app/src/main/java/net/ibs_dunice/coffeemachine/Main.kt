fun main() {
    var philips = coffemachin();
    philips.start();
}

 class coffemachin(vararg peremen: Int, status: Boolean) {
    private var status_coffemachine = true;
    private var clear = 10; private var milk = 1000; private var water = 3000; private var coffe = 400;



    fun start() {
        println("Добро Пожаловать в программу Кофемашина\n_________")
        println("Статус кофемашины выключен\nДля включения нажмите 1\nДля выключения нажмите 2")
        var pressing = readLine();
        while (pressing != "1" || pressing != "2") {      // цикл пока не будет 1 или 2
            when (pressing) {
                "1" -> { println("Кофемашина включена\n");status_coffemachine = true;selection_menu(); }
                "2" -> { println("Кофемашина выключена\n");status_coffemachine = false;exit(); }
                else -> { println("Неверная комадна, нажмите от 1 до 2");pressing = readLine() }
                }
            }
        }

    private fun selection_menu() {
                println("Выберите дальнейшие действия:" +
                        "\n1. Приготовить кофе" +
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
            println("Неверная команда, попробуйте снова\n Нажмите от 1 до 4")
            pressing = readLine();
                }
            }
        }
    }

    private fun cook_coffe() {
        println("Выберите кофе\n1. Капучино\n2. Экспрессо\n3. Сделать свой кофе\n4. Назад в меню")
        if (clear >= 0) {
            val pressing = readLine();
            while (pressing != "1" || pressing != "2" || pressing != "3" || pressing != "4") {
                when (pressing) {
                    "1" -> { println("Затраты на капучино\nМолока - 100\t Кофе - 10\tВоды - 250\nНажмите enter для продолжения")
                             readLine()
                             checking_for(); //Проверка на количество индигриентов
                             milk -= 100;coffe -= 10;water -= 2500;clear--;
                             println("Капучино готов\nНажмите enter для выхода в меню")
                             readLine()
                             selection_menu(); }
                    "2" -> { println("Затраты на экспрессо\tМолока - 0\tКофе - 30\tВоды - 250\nНажмите enter для продолжения")
                             readLine()
                             checking_for();
                             coffe -= 30;water -= 250;clear--
                             println("Экспрессо готов\n Нажмите enter для выхода в меню")
                             readLine()
                             selection_menu(); }
                    "3" ->   my_own_coffee()
                    "4" ->   selection_menu()
                }
            }
        } else { println("Производиться чистка. Ожидайте\n________");clear = 10;selection_menu(); }
    }


    private fun quantity_of_ingredients() {
        println("КОЛИЧЕСТВО ИНДИГРИЕНТОВ МАШИНЫ:\nКофе: $coffe\nМолока :$milk\nВоды :$water")
        println("Нажмите enter для выхода в меню")
        readLine(); selection_menu();
    }

    private fun clear() {
        println("До чистки осталось <$clear> кружек кофе\n________________\n Нажмите enter для выхода в меню")
        readLine()
        selection_menu()
    }

    private fun exit() { return }

    private fun my_own_coffee() {
        println("Выберите количество индигриентов\n\t Кофе:\n1. 10 гр\n2. 30 гр\n3. 50 гр")
        if (clear >= 0) {
                val pressing = readLine()
            while (pressing!= "1" || pressing !="2"||pressing !="3") {
                when (pressing) {
                    "1" -> {
                        checking_for(); coffe -= 10
                    }
                    "2" -> {
                        checking_for();coffe -= 30
                    }
                    "3" -> {
                        checking_for();coffe -= 50
                    }
                    else -> {
                        println("Нажмите от 1 до 3")
                    }
                }
            }
                println("Молоко:\n1. 50 гр\n2. 100 гр\n3. 150 гр")
                val pressing2 = readLine()
            while (pressing2 != "1" || pressing2 !="2"||pressing !="3") {
                when (pressing2) {
                    "1" -> {
                        checking_for();milk -= 50
                    }
                    "2" -> {
                        checking_for();milk -= 100
                    }
                    "3" -> {
                        checking_for();milk -= 150
                    }
                    else -> {
                        println("Нажмите от 1 до 3")
                    }
                }
            }
                println("Размер стакана:\n1. воды 150 гр\n2. воды 200 гр\n3. воды 250 гр")
                val pressing3 = readLine()
                while (pressing3 != "1" || pressing3 !="2"||pressing3 !="3") {
                when (pressing3) {
                    "1" -> { checking_for();water -= 150 }
                    "2" -> { checking_for();water -= 200 }
                    "3" -> { checking_for();water -= 250 }
                    else -> { println("Нажмите от 1 до 3") }
                }
            }
        }else { println("Производиться чистка. Ожидайте\n____________");clear = 10;selection_menu(); }
        clear--;
        println("Ваш кофе готов\n Нажмите enter для выхода в меню")

        readLine();
        selection_menu();
    }

    private fun checking_for() {


        if (water <= 0) {
            println("Недостаточно воды\nСколько воды налить? от 1 до 3000")
            val pressing:String = readLine()?: "error"
            if (pressing in "1".."3000")
            { println("вы налили $pressing воды")
                val b:Int = pressing.toInt()
                water += b
                println("Количество воды:  $water мл")
            }else{
                println("Значение некоректно")
            }
        }








        else if (milk <= 0) {
            println("Недостаточно молока\nСколько маолока налить? от 1 до 1000")
            val pressing:String = readLine()?: "error"
            if (pressing in "1".."1000") {
                println("вы налили $pressing молока")
                val b: Int = pressing.toInt()
                milk += b
                println("Количество молока:  $milk мл")
                println("Нажмите enter для перехода в меню")
                readLine()
                selection_menu();
            }else{
                println("Значение некоректно")
            }








        }else if (coffe <= 0) {
            println("Недостаточно кофе\nСколько кофе насыпать? От 1 до 400")
            val pressing:String = readLine()?: "error"
            if (pressing in "1".."400") {

                val b: Int = pressing.toInt()
                coffe += b
                if (coffe>400) {
                    println("Перебор кофе")
                }
                println("вы налили $pressing кофе")

                println("Количество кофе:  $coffe мл")
                println("Нажмите enter для перехода в меню")
                readLine()
                selection_menu();
            }else{
                println("Значение некоректно")
            }
        }

    }
}

