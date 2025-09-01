package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.view.LiveData;
import androidx.work.Data;
import androidx.work.impl.model.WorkSpec;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    /* renamed from: androidx.work.impl.model.RawWorkInfoDao_Impl$1, reason: invalid class name */
    public class AnonymousClass1 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        public final /* synthetic */ SupportSQLiteQuery val$_internalQuery;

        public AnonymousClass1(SupportSQLiteQuery supportSQLiteQuery) {
            this.val$_internalQuery = supportSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<WorkSpec.WorkInfoPojo> call() throws Exception {
            return call2();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public List<WorkSpec.WorkInfoPojo> call2() throws Exception {
            Cursor cursorQuery = DBUtil.query(RawWorkInfoDao_Impl.access$000(RawWorkInfoDao_Impl.this), this.val$_internalQuery, true, null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
                int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, "state");
                int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
                int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = new ArrayMap();
                while (cursorQuery.moveToNext()) {
                    if (!cursorQuery.isNull(columnIndex)) {
                        String string = cursorQuery.getString(columnIndex);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                    }
                    if (!cursorQuery.isNull(columnIndex)) {
                        String string2 = cursorQuery.getString(columnIndex);
                        if (((ArrayList) arrayMap2.get(string2)) == null) {
                            arrayMap2.put(string2, new ArrayList());
                        }
                    }
                }
                cursorQuery.moveToPosition(-1);
                RawWorkInfoDao_Impl.access$100(RawWorkInfoDao_Impl.this, arrayMap);
                RawWorkInfoDao_Impl.access$200(RawWorkInfoDao_Impl.this, arrayMap2);
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    ArrayList arrayList2 = !cursorQuery.isNull(columnIndex) ? (ArrayList) arrayMap.get(cursorQuery.getString(columnIndex)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    ArrayList arrayList3 = !cursorQuery.isNull(columnIndex) ? (ArrayList) arrayMap2.get(cursorQuery.getString(columnIndex)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    if (columnIndex != -1) {
                        workInfoPojo.f40id = cursorQuery.getString(columnIndex);
                    }
                    if (columnIndex2 != -1) {
                        workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndex2));
                    }
                    if (columnIndex3 != -1) {
                        workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndex3));
                    }
                    if (columnIndex4 != -1) {
                        workInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndex4);
                    }
                    workInfoPojo.tags = arrayList2;
                    workInfoPojo.progress = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                return arrayList;
            } finally {
                cursorQuery.close();
            }
        }
    }

    public RawWorkInfoDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
    }

    private void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap<String, ArrayList<Data>> arrayMap) {
        ArrayList<Data> arrayList;
        int i;
        Set<String> setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            int size = arrayMap.size();
            int i2 = 0;
            loop0: while (true) {
                i = 0;
                while (i2 < size) {
                    arrayMap2.put(arrayMap.keyAt(i2), arrayMap.valueAt(i2));
                    i2++;
                    i++;
                    if (i == 999) {
                        break;
                    }
                }
                __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                arrayMap2 = new ArrayMap<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            }
            if (i > 0) {
                __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int size2 = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size2);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size2 + 0);
        int i3 = 1;
        for (String str : setKeySet) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i3);
            } else {
                roomSQLiteQueryAcquire.bindString(i3, str);
            }
            i3++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                if (!cursorQuery.isNull(columnIndex) && (arrayList = arrayMap.get(cursorQuery.getString(columnIndex))) != null) {
                    arrayList.add(Data.fromByteArray(cursorQuery.getBlob(0)));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    private void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> arrayMap) {
        ArrayList<String> arrayList;
        int i;
        Set<String> setKeySet = arrayMap.keySet();
        if (setKeySet.isEmpty()) {
            return;
        }
        if (arrayMap.size() > 999) {
            ArrayMap<String, ArrayList<String>> arrayMap2 = new ArrayMap<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            int size = arrayMap.size();
            int i2 = 0;
            loop0: while (true) {
                i = 0;
                while (i2 < size) {
                    arrayMap2.put(arrayMap.keyAt(i2), arrayMap.valueAt(i2));
                    i2++;
                    i++;
                    if (i == 999) {
                        break;
                    }
                }
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                arrayMap2 = new ArrayMap<>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
            }
            if (i > 0) {
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                return;
            }
            return;
        }
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int size2 = setKeySet.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size2);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size2 + 0);
        int i3 = 1;
        for (String str : setKeySet) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i3);
            } else {
                roomSQLiteQueryAcquire.bindString(i3, str);
            }
            i3++;
        }
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, "work_spec_id");
            if (columnIndex == -1) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                if (!cursorQuery.isNull(columnIndex) && (arrayList = arrayMap.get(cursorQuery.getString(columnIndex))) != null) {
                    arrayList.add(cursorQuery.getString(0));
                }
            }
        } finally {
            cursorQuery.close();
        }
    }

    public static /* synthetic */ RoomDatabase access$000(RawWorkInfoDao_Impl rawWorkInfoDao_Impl) {
        return rawWorkInfoDao_Impl.__db;
    }

    public static /* synthetic */ void access$100(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, ArrayMap arrayMap) {
        rawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
    }

    public static /* synthetic */ void access$200(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, ArrayMap arrayMap) {
        rawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap);
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public List<WorkSpec.WorkInfoPojo> getWorkInfoPojos(SupportSQLiteQuery supportSQLiteQuery) {
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, supportSQLiteQuery, true, null);
        try {
            int columnIndex = CursorUtil.getColumnIndex(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            int columnIndex2 = CursorUtil.getColumnIndex(cursorQuery, "state");
            int columnIndex3 = CursorUtil.getColumnIndex(cursorQuery, "output");
            int columnIndex4 = CursorUtil.getColumnIndex(cursorQuery, "run_attempt_count");
            ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
            ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
            while (cursorQuery.moveToNext()) {
                if (!cursorQuery.isNull(columnIndex)) {
                    String string = cursorQuery.getString(columnIndex);
                    if (arrayMap.get(string) == null) {
                        arrayMap.put(string, new ArrayList<>());
                    }
                }
                if (!cursorQuery.isNull(columnIndex)) {
                    String string2 = cursorQuery.getString(columnIndex);
                    if (arrayMap2.get(string2) == null) {
                        arrayMap2.put(string2, new ArrayList<>());
                    }
                }
            }
            cursorQuery.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ArrayList<String> arrayList2 = !cursorQuery.isNull(columnIndex) ? arrayMap.get(cursorQuery.getString(columnIndex)) : null;
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>();
                }
                ArrayList<Data> arrayList3 = !cursorQuery.isNull(columnIndex) ? arrayMap2.get(cursorQuery.getString(columnIndex)) : null;
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList<>();
                }
                WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                if (columnIndex != -1) {
                    workInfoPojo.f40id = cursorQuery.getString(columnIndex);
                }
                if (columnIndex2 != -1) {
                    workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndex2));
                }
                if (columnIndex3 != -1) {
                    workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndex3));
                }
                if (columnIndex4 != -1) {
                    workInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndex4);
                }
                workInfoPojo.tags = arrayList2;
                workInfoPojo.progress = arrayList3;
                arrayList.add(workInfoPojo);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    @Override // androidx.work.impl.model.RawWorkInfoDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkInfoPojosLiveData(SupportSQLiteQuery supportSQLiteQuery) {
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress"}, false, new AnonymousClass1(supportSQLiteQuery));
    }
}
