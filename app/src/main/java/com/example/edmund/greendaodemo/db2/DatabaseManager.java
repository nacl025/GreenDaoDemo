package com.example.edmund.greendaodemo.db2;

import android.content.Context;

import com.example.edmund.greendaodemo.dao.DaoMaster;
import com.example.edmund.greendaodemo.dao.DaoSession;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.database.Database;

public class DatabaseManager {
    public static final String mDBName = "xxx.db";
    private DaoSession mDaoSession = null;
    /*private NavModelDao favModelDao = null;
    private VideoModelDao videoModelDao = null;
    private VideoStatusModelDao videoStatusModelDao = null;
    private PlayListDao playListDao = null;
    private PlaylistDetailListDao playlistDetailListDao;*/


    private DatabaseManager() {
    }

    public DatabaseManager init(Context context, Class<? extends AbstractDao<?, ?>>... daoClasses) {
        initDao(context, daoClasses);
        return this;
    }

    private static final class Holder {
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance() {
        return Holder.INSTANCE;
    }

    private void initDao(Context context, Class<? extends AbstractDao<?, ?>>... daoClasses) {
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, mDBName, daoClasses);
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        /*favModelDao = mDaoSession.getNavModelDao();
        videoModelDao = mDaoSession.getVideoModelDao();
        videoStatusModelDao = mDaoSession.getVideoStatusModelDao();
        playListDao = mDaoSession.getPlayListDao();
        playlistDetailListDao = mDaoSession.getPlaylistDetailListDao();*/


    }

    /*public final NavModelDao getNavDao() {
        return favModelDao;
    }

    public final VideoModelDao getVideoModelDao() {
        return videoModelDao;
    }

    public final VideoStatusModelDao getVideoStatusModelDao() {
        return videoStatusModelDao;
    }

    public final PlayListDao getVideoPlayListDao() {
        return playListDao;
    }

    public final PlaylistDetailListDao getVideoPlayListDetailDao() {
        return playlistDetailListDao;
    }*/
}
