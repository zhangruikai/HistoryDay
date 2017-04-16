package com.baway.library.inject;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

/**
 * 类描述：
 * 创建人：yekh
 * 创建时间：2017/3/17 16:11
 */
public class InjectUtils {
    public static void init(Activity act){
        setContentView(act);
        inject(act);
    }

    private static void inject(Activity act) {
        Class cls = act.getClass();
        Field [] fields = cls.getDeclaredFields();
        for(Field field : fields){
            Inject inject = field.getAnnotation(Inject.class);
            if(inject!=null){
                int id = inject.value();
                View view = act.findViewById(id);
                field.setAccessible(true);
                try {
                    field.set(act,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void setContentView(Activity act) {
        Class cls = act.getClass();
        ContentView contentview = (ContentView) cls.getAnnotation(ContentView.class);
        if(contentview!=null){
            int layoutId = contentview.value();
            act.setContentView(layoutId);
        }
    }
}
