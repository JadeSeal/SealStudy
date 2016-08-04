package com.jade.greendao.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.jade.greendao.biz.db.entiy.User;
import com.jade.greendao.gen.DaoMaster;
import com.jade.greendao.gen.DaoSession;
import com.jade.greendao.gen.UserDao;

import org.greenrobot.greendao.database.DatabaseOpenHelper;

import java.util.List;

/**
 * Created by jade on 16-8-4.
 */
public class DataManager {
    private static DataManager instance;
    private Context mContext;
    private final UserDao mUserDao;

    public static DataManager getInstance(Context context) {
        if (instance == null) {
            synchronized (DataManager.class) {
                if (instance == null) {
                    instance = new DataManager(context);
                }
            }
        }
        return instance;
    }

    private DataManager(Context context) {
        this.mContext = context;

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(mContext, "user-db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        mUserDao = daoSession.getUserDao();
    }

    public void insertUser(User user) {
        mUserDao.insert(user);
    }

    public void deleteUser(String name) {
        User user = mUserDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().unique();
        mUserDao.deleteByKey(user.getId());
    }

    public void updateUser(String name, User newUser) {
        User oldUser = mUserDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().unique();
        if (oldUser != null) {
            oldUser = newUser;
            mUserDao.update(oldUser);
        } else {
            Log.d(this.getClass().getSimpleName(), "没有找到");
        }
    }

    public User queryUser(String name) {
        return mUserDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).build().unique();
    }

    public List<User> queryUsers() {
        return mUserDao.queryBuilder()
                .where(UserDao.Properties.Id.notEq(-1))
                .orderAsc(UserDao.Properties.Id)
                .limit(5)
                .build().list();
    }

}
