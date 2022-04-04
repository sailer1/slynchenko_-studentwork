fun main() {
    var philips:coffemachin = coffemachin();
    philips.start();
}

public class coffemachin() {
    private var status_coffemachine = true;
    private var clear = 10;
    private var back = true;
    private var milk = 1000;
    private var water = 3000;
    private var coffe = 1000;

    fun start() {
        println(
            "Добро Пожаловать в программу Кофемашина\n_______________________________" +
                    "\nДля продолжения нажмите любую клавишу"
        )
        readLine();
        println(
            "Статус кофемашины выключен" +
                    "\nДля включения нажмите 1" +
                    "\nДля выключения нажмите 2"
        )
        var d = readLine();
        when (d) {
            "1" -> {
                println("Кофемашина включена\n\n\n")
                status_coffemachine = false;
            }
            "2" -> {
                println("Кофемашина выключена\n\n\n")
                status_coffemachine = true;
            }
        }
        selection_menu();
    }

    private fun selection_menu() {

        if (status_coffemachine == false) {
            while (back) {
                println(
                    "Выберите дальнейшие действия:" +
                            "\n1. Приготовить кофе" +
                            "\n2. Посмотреть количество индигриентов кофемашины" +
                            "\n3. Проверить сколько кружек кофе до чистки" +
                            "\n4. Выйти из приложения"
                )
                var status_coffe = readLine();

                when (status_coffe) {
                    "1" -> {
                        cook_coffe()
                    };
                    "2" -> {
                        kol_indi()
                    };
                    "3" -> {
                        clear()
                    };
                    "4" -> {back = false
                        exit();
                    }
                    else -> {
                        println("Неверная команда, попробуйте снова\n Нажмите от 1 до 4 в зависимости что хотите")
                        back = true;
                    }
                }
            }
        }
    }


    private fun cook_coffe() {
        println("Выберите кофе\n1. Капучино\n2. Экспрессо\n3. Сделать свой кофе\n4. Назад в меню")
        if (clear > 0) {
            var a = readLine();
            when (a) {
                "1" -> {
                    checking_for();
                    println("Капучино готов")
                    milk -= 100;
                    coffe -= 10;
                    water -= 250;
                    clear--
                    selection_menu();
                }
                "2" -> {
                    checking_for();
                    println("Экспрессо готов")
                    coffe -= 30;
                    water -= 250;
                    selection_menu();
                    clear--
                }
                "3" -> my_own_coffee()
            }
        } else {
            println("Производиться чистка. Ожидайте\n_______________________________")
            clear = 10;
            selection_menu();
        }
    }


    private fun kol_indi() {
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
        println("До чистки осталось <$clear> кружек кофе")
        selection_menu();
    }

    private fun exit() {
        return;
    }

    private fun my_own_coffee() {
        println("Выберите количество индигриентов\n\t Кофе:\n1. 10 гр\n2. 30 гр\n3. 50 гр")

        while (back) {
            var coffee_selection = readLine()
            when (coffee_selection) {
                "1" -> {
                    checking_for();
                    coffe -= 10
                    back = false
                }
                "2" -> {
                    checking_for();
                    coffe -= 30
                    back = false
                }
                "3" -> {
                    checking_for();
                    coffe -= 50
                    back = false
                }
                else -> {
                    println("Нажмите от 1 до 3")
                    back = true;
                }
            }
        }
        back = true
        println("Молоко:\n1. 50 гр\n2. 100 гр\n3. 150 гр")
        while (back) {
            var milk_selection = readLine()
            when (milk_selection) {
                "1" -> {
                    checking_for();
                    milk -= 50
                    back = false
                }
                "2" -> {
                    checking_for();
                    milk -= 100
                    back = false
                }
                "3" -> {
                    checking_for();
                    milk -= 150
                    back = false
                }
                else -> {
                    println("Нажмите от 1 до 3")
                    back = true;
                }
            }
        }
        back = true
        println("Размер стакана:\n1. воды 150 гр\n2. воды 200 гр\n3. воды 250 гр")
        while (back) {
            var water_selection = readLine()
            when (water_selection) {
                "1" -> {
                    checking_for();
                    water -= 150
                    back = false
                }
                "2" -> {
                    checking_for();
                    water -= 200
                    back = false
                }
                "3" -> {
                    checking_for();
                    water -= 250
                    back = false
                }
                else -> {
                    println("Нажмите от 1 до 3")
                    back = true;
                }
            }
        }
        back = true
        println("Ваш кофе готов\n Нажмите любую клавишу для продолжения")
        clear--;
        readLine();
        selection_menu();
    }

    fun checking_for() {
        if (water <= 0) {
            println("Недостаточно воды\nНажмите на любую клавишу чтобы налить воды")
            readLine()
            water = 3000;
            println("Количество воды:  $water мл")
            readLine()
            selection_menu();
        }
        if (milk <= 0) {
            println("Недостаточно молока\nНажмите на любую клавишу чтобы налить молока")
            readLine()
            milk = 1000;
            println("Количество молока:  $milk мл")
            readLine()
            selection_menu();
        }
        if (coffe <= 0) {
            println("Недостаточно кофе\nНажмите на любую клавишу чтобы досыпать кофе")
            readLine()
            coffe = 1000;
            println("Количество кофе:  $coffe гр")
            readLine()
            selection_menu();
        }
    }
}

