package sem2HW;

/*Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки. Если значение null, 
то параметр не должен попадать в запрос. Параметры для фильтрации: 
{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
то есть должно получиться что-то вроде:
... where name = Ivanov and country = Russia and city = Moscow */

import java.util.HashMap;
import java.util.Map;

public class Task01Sem2HW {
    public static void main(String[] args) {
        Map<String, String> param = new HashMap<>();

        param.put("name", "Ivanov");
        param.put("country", "Russia");
        param.put("city", "Moscow");
        param.put("age", null);
        System.out.println(param);

        StringBuilder sb = new StringBuilder();
        sb.append("select * from students where ");
        boolean notFirst = false;
        //предполагаю, что порядок перечисления аргументов не имеет значения в данном запросе,
        //поэтому обрабатываю в цикле, иначе искала бы по конкретным ключам
        for(Map.Entry<String, String> entry: param.entrySet()) {
            //if (! entry.getValue().equals("null"))
            if (entry.getValue()!=null) {
                if (notFirst) sb.append(" and ");
                sb.append(String.format("%s = \"%s\"", entry.getKey(), entry.getValue()));
                notFirst = true;
            }
        }
        System.out.println(sb);
        //select * from students where country = "Russia" and city = "Moscow" and name = "Ivanov"
    }
}
