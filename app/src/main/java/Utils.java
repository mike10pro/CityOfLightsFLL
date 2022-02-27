import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.CityOfLightsFLL.MainActivity;
import com.example.CityOfLightsFLL.ServerUse;

public class Utils {
    public static boolean hasConnection(final Context context)
    {
        ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        wifiInfo = cm.getActiveNetworkInfo();
        if (wifiInfo != null && wifiInfo.isConnected())
        {
            return true;
        }
        return false;
    }
    public static void SaveData(Context context) {
        if (Utils.hasConnection(context)) {
            ServerUse.GetProblems();
            SharedPreferences sharedPreferences = context.getSharedPreferences("Problems", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Probl", MainActivity.data);
            editor.apply();
            ServerUse.GetTest();
            sharedPreferences = context.getSharedPreferences("Test", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putString("Test", MainActivity.data);
            editor.apply();
            ServerUse.GetAboutUs();
            sharedPreferences = context.getSharedPreferences("Ab_Us", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putString("Ab_Us", MainActivity.data);
            editor.apply();
        } else {
            SharedPreferences sharedPreferences = context.getSharedPreferences("Problems", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("Test", "[[1,\"Если вы садитесь в машину, замечаете ли вы дым в салоне?\",\"Если дым идет внутри машины, то скорее всего, происходит утечка выхлопных газов где-то под днищем. В таком случае не стоит продолжать движение в автомобиле, поскольку угарный газ, собравшийся в салоне, может вызвать потерю сознания и даже смерть.\",\"да|нет\"],[2,\"Чувствуете ли вы запах бензина или масла?\",\"Запах бензина или масла обычно указывает на то, что одна из этих жидкостей протекает. Бензин может течь из бака, а также из-под прохудившихся хомутов, образуя пахнущие лужи на асфальте. А масло начинает капать из уплотнений в изношенном двигателе и соединений в подвеске.\",\"да|нет\"],[3,\"Чувствуете ли вы запах серы?\",\"Если вы чувствуете запах серы, то скорее всего из строя вышел катализатор, а также возможны проблемы с аккумулятором.\",\"да|нет\"],[4,\"Чувствуете ли вы запах жженого дерева или резины?\",\"Если вы чувствуете запах жженого дерева или резины, то причиной может стать длительное торможение, езда с затянутым ручником, заклинивание тормозного суппорта, сгоревшее сцепление.\",\"да|нет\"],[5,\"Если вы садитесь за руль, то чувствуете вибрации и потряхивания рулевого колеса, или руль слишком \\\"свободный\\\", или наоборот, слишком тугий?\",\"Вибрации и потряхивания рулевого колеса указывают на проблему с колесами или тормозами.|Если руль слишком «свободный», с большим люфтом, то это указывает на проблему с тягами или шаровыми шарнирами.|Если же руль вращается слишком туго, то налицо проблемы с гидро- или электроусилителем.|всё хорошо\",\"Вибрации и потряхивания|Руль слишком \\\"свободный\\\"|Руль тугой|Ничего\"],[6,\"Чувствуете ли вы вибрации, при нажатии педали тормоза?\",\"Если вы чувствуете вибрации, то скорее всего произошел износ тормозных колодок и биении роторов.\",\"да|нет\"],[7,\"При повороте машины, производится ли скрип?\",\"Скрипы, появляющиеся в поворотах, свидетельствуют об износе подвески или рулевого управления.\",\"да|нет\"],[8,\"При торможении машины, производится ли скрип?\",\"Скрип при торможении – это, очевидно, следствие «убитых» тормозов и тормозных дисках.\",\"да|нет\"],[9,\"Есть ли свист под капотом?\",\"При свисте под капотом скорее всего проблема в изношенном ремне или «умершей» водяной помпе.\",\"да|нет\"]]\n");
            editor.apply();
            sharedPreferences = context.getSharedPreferences("Problems", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putString("Probl", "[[2,\"Чувствуете ли вы запах бензина или масла?\",\"Запах бензина или масла обычно указывает на то, что одна из этих жидкостей протекает. Бензин может течь из бака, а также из-под прохудившихся хомутов, образуя пахнущие лужи на асфальте. А масло начинает капать из уплотнений в изношенном двигателе и соединений в подвеске.\"],[3,\"Чувствуете ли вы запах серы?\",\"Если вы чувствуете запах серы, то скорее всего из строя вышел катализатор, а также возможны проблемы с аккумулятором.\"],[4,\"Чувствуете ли вы запах жженого дерева или резины?\",\"Если вы чувствуете запах жженого дерева или резины, то причиной может стать длительное торможение, езда с затянутым ручником, заклинивание тормозного суппорта, сгоревшее сцепление.\"],[5,\"Если вы садитесь за руль, то чувствуете вибрации и потряхивания рулевого колеса, или руль слишком \\\"свободный\\\", или наоборот, слишком тугий?\",\"Вибрации и потряхивания рулевого колеса указывают на проблему с колесами или тормозами. Если руль слишком «свободный», с большим люфтом, то это указывает на проблему с тягами или шаровыми шарнирами. Если же руль вращается слишком туго, то налицо проблемы с гидро- или электроусилителем.\"],[6,\"Чувствуете ли вы вибрации, при нажатии педали тормоза?\",\"Если вы чувствуете вибрации, то скорее всего произошел износ тормозных колодок и биении роторов.\"],[7,\"При повороте машины, производится ли скрип?\",\"Скрипы, появляющиеся в поворотах, свидетельствуют об износе подвески или рулевого управления.\"],[8,\"При торможении машины, производится ли скрип?\",\"Скрип при торможении – это, очевидно, следствие «убитых» тормозов и тормозных дисках.\"],[9,\"Есть ли свист под капотом?\",\"При свисте под капотом скорее всего проблема в изношенном ремне или «умершей» водяной помпе.\"]]\n");
            editor.apply();
            sharedPreferences = context.getSharedPreferences("Ab_Us", Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
            editor.putString("Ab_Us", "Мы никто");
            editor.apply();
        }

    }
}
