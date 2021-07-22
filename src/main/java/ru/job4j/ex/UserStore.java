package ru.job4j.ex;

/**
 * 4. Вам необходимо реализовать метод findUser, validate и main.
 *
 * findUser - если пользователя не нашли в списке, то кинуть исключение UserNotFoundException.
 *
 * validate - если пользователь не валидный или если имя пользователя состоит из менее трех символов,
 * то кинуть исключение UserInvalidException
 *
 * Метод validate принимает аргумент user. У объекта user есть метод isValid(). Если он false,
 * то нужно выкинуть исключение UserInvalidException.
 *
 * Так же в этом методе нужно проверить, что у объекта user количество символов в поле username меньше 3.
 * Если оно меньше, то нужно выкинуть исключение UserInvalidException. Для этого нужно воспользоваться методом String.length().
 *
 * main - поправить код за счет использования try-catch с множественным блоком catch.
 *
 * В блоке catch(UserNotFoundException) - должно быть выведено на консоль сообщение, что пользователя не найдено.
 *
 * В блоке  catch(UserInvalidException) - должно быть выведено на консоль сообщение, что пользователь не валидный.
 */
public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                return user;
            }
        }
        throw new UserNotFoundException("User " + login + " not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() <3) {
            throw new UserInvalidException("User not validate");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Пе", true),
                new User("Демид Иванов", false),
                new User("Александра Соколова", false)
        };
        User user = null;
        try {
            user = findUser(users, "Пе");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            e.printStackTrace();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }
}
