package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.view.LiveData;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class WorkSpecDao_Impl implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetPeriodStartTime;

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$1, reason: invalid class name */
    public class AnonymousClass1 extends EntityInsertionAdapter<WorkSpec> {
        public AnonymousClass1(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public /* bridge */ /* synthetic */ void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) throws Throwable {
            bind2(supportSQLiteStatement, workSpec);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: bind, reason: avoid collision after fix types in other method */
        public void bind2(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) throws Throwable {
            String str = workSpec.f38id;
            if (str == null) {
                supportSQLiteStatement.bindNull(1);
            } else {
                supportSQLiteStatement.bindString(1, str);
            }
            supportSQLiteStatement.bindLong(2, WorkTypeConverters.stateToInt(workSpec.state));
            String str2 = workSpec.workerClassName;
            if (str2 == null) {
                supportSQLiteStatement.bindNull(3);
            } else {
                supportSQLiteStatement.bindString(3, str2);
            }
            String str3 = workSpec.inputMergerClassName;
            if (str3 == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, str3);
            }
            byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
            if (byteArrayInternal == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindBlob(5, byteArrayInternal);
            }
            byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
            if (byteArrayInternal2 == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
            }
            supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
            supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
            supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
            supportSQLiteStatement.bindLong(10, workSpec.runAttemptCount);
            supportSQLiteStatement.bindLong(11, WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
            supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
            supportSQLiteStatement.bindLong(13, workSpec.periodStartTime);
            supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
            supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
            supportSQLiteStatement.bindLong(16, workSpec.runInForeground ? 1L : 0L);
            Constraints constraints = workSpec.constraints;
            if (constraints == null) {
                supportSQLiteStatement.bindNull(17);
                supportSQLiteStatement.bindNull(18);
                supportSQLiteStatement.bindNull(19);
                supportSQLiteStatement.bindNull(20);
                supportSQLiteStatement.bindNull(21);
                supportSQLiteStatement.bindNull(22);
                supportSQLiteStatement.bindNull(23);
                supportSQLiteStatement.bindNull(24);
                return;
            }
            supportSQLiteStatement.bindLong(17, WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
            supportSQLiteStatement.bindLong(18, constraints.requiresCharging() ? 1L : 0L);
            supportSQLiteStatement.bindLong(19, constraints.requiresDeviceIdle() ? 1L : 0L);
            supportSQLiteStatement.bindLong(20, constraints.requiresBatteryNotLow() ? 1L : 0L);
            supportSQLiteStatement.bindLong(21, constraints.requiresStorageNotLow() ? 1L : 0L);
            supportSQLiteStatement.bindLong(22, constraints.getTriggerContentUpdateDelay());
            supportSQLiteStatement.bindLong(23, constraints.getTriggerMaxContentDelay());
            byte[] bArrContentUriTriggersToByteArray = WorkTypeConverters.contentUriTriggersToByteArray(constraints.getContentUriTriggers());
            if (bArrContentUriTriggersToByteArray == null) {
                supportSQLiteStatement.bindNull(24);
            } else {
                supportSQLiteStatement.bindBlob(24, bArrContentUriTriggersToByteArray);
            }
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$10, reason: invalid class name */
    public class AnonymousClass10 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        public final /* synthetic */ RoomSQLiteQuery val$_statement;

        public AnonymousClass10(RoomSQLiteQuery roomSQLiteQuery) {
            this.val$_statement = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<WorkSpec.WorkInfoPojo> call() throws Exception {
            return call2();
        }

        public void finalize() {
            this.val$_statement.release();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public List<WorkSpec.WorkInfoPojo> call2() throws Exception {
            WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this).beginTransaction();
            try {
                Cursor cursorQuery = DBUtil.query(WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this), this.val$_statement, true, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (cursorQuery.moveToNext()) {
                        if (!cursorQuery.isNull(columnIndexOrThrow)) {
                            String string = cursorQuery.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap.get(string)) == null) {
                                arrayMap.put(string, new ArrayList());
                            }
                        }
                        if (!cursorQuery.isNull(columnIndexOrThrow)) {
                            String string2 = cursorQuery.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap2.get(string2)) == null) {
                                arrayMap2.put(string2, new ArrayList());
                            }
                        }
                    }
                    cursorQuery.moveToPosition(-1);
                    WorkSpecDao_Impl.access$100(WorkSpecDao_Impl.this, arrayMap);
                    WorkSpecDao_Impl.access$200(WorkSpecDao_Impl.this, arrayMap2);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        ArrayList arrayList2 = !cursorQuery.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !cursorQuery.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.f40id = cursorQuery.getString(columnIndexOrThrow);
                        workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                        workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                        workInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow4);
                        workInfoPojo.tags = arrayList2;
                        workInfoPojo.progress = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this).setTransactionSuccessful();
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            } finally {
                WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this).endTransaction();
            }
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$11, reason: invalid class name */
    public class AnonymousClass11 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        public final /* synthetic */ RoomSQLiteQuery val$_statement;

        public AnonymousClass11(RoomSQLiteQuery roomSQLiteQuery) {
            this.val$_statement = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<WorkSpec.WorkInfoPojo> call() throws Exception {
            return call2();
        }

        public void finalize() {
            this.val$_statement.release();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public List<WorkSpec.WorkInfoPojo> call2() throws Exception {
            WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this).beginTransaction();
            try {
                Cursor cursorQuery = DBUtil.query(WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this), this.val$_statement, true, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (cursorQuery.moveToNext()) {
                        if (!cursorQuery.isNull(columnIndexOrThrow)) {
                            String string = cursorQuery.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap.get(string)) == null) {
                                arrayMap.put(string, new ArrayList());
                            }
                        }
                        if (!cursorQuery.isNull(columnIndexOrThrow)) {
                            String string2 = cursorQuery.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap2.get(string2)) == null) {
                                arrayMap2.put(string2, new ArrayList());
                            }
                        }
                    }
                    cursorQuery.moveToPosition(-1);
                    WorkSpecDao_Impl.access$100(WorkSpecDao_Impl.this, arrayMap);
                    WorkSpecDao_Impl.access$200(WorkSpecDao_Impl.this, arrayMap2);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        ArrayList arrayList2 = !cursorQuery.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !cursorQuery.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.f40id = cursorQuery.getString(columnIndexOrThrow);
                        workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                        workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                        workInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow4);
                        workInfoPojo.tags = arrayList2;
                        workInfoPojo.progress = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this).setTransactionSuccessful();
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            } finally {
                WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this).endTransaction();
            }
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$12, reason: invalid class name */
    public class AnonymousClass12 implements Callable<List<WorkSpec.WorkInfoPojo>> {
        public final /* synthetic */ RoomSQLiteQuery val$_statement;

        public AnonymousClass12(RoomSQLiteQuery roomSQLiteQuery) {
            this.val$_statement = roomSQLiteQuery;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ List<WorkSpec.WorkInfoPojo> call() throws Exception {
            return call2();
        }

        public void finalize() {
            this.val$_statement.release();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.Callable
        /* renamed from: call, reason: avoid collision after fix types in other method */
        public List<WorkSpec.WorkInfoPojo> call2() throws Exception {
            WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this).beginTransaction();
            try {
                Cursor cursorQuery = DBUtil.query(WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this), this.val$_statement, true, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (cursorQuery.moveToNext()) {
                        if (!cursorQuery.isNull(columnIndexOrThrow)) {
                            String string = cursorQuery.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap.get(string)) == null) {
                                arrayMap.put(string, new ArrayList());
                            }
                        }
                        if (!cursorQuery.isNull(columnIndexOrThrow)) {
                            String string2 = cursorQuery.getString(columnIndexOrThrow);
                            if (((ArrayList) arrayMap2.get(string2)) == null) {
                                arrayMap2.put(string2, new ArrayList());
                            }
                        }
                    }
                    cursorQuery.moveToPosition(-1);
                    WorkSpecDao_Impl.access$100(WorkSpecDao_Impl.this, arrayMap);
                    WorkSpecDao_Impl.access$200(WorkSpecDao_Impl.this, arrayMap2);
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        ArrayList arrayList2 = !cursorQuery.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = !cursorQuery.isNull(columnIndexOrThrow) ? (ArrayList) arrayMap2.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                        workInfoPojo.f40id = cursorQuery.getString(columnIndexOrThrow);
                        workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                        workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                        workInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow4);
                        workInfoPojo.tags = arrayList2;
                        workInfoPojo.progress = arrayList3;
                        arrayList.add(workInfoPojo);
                    }
                    WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this).setTransactionSuccessful();
                    return arrayList;
                } finally {
                    cursorQuery.close();
                }
            } finally {
                WorkSpecDao_Impl.access$000(WorkSpecDao_Impl.this).endTransaction();
            }
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$2, reason: invalid class name */
    public class AnonymousClass2 extends SharedSQLiteStatement {
        public AnonymousClass2(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$3, reason: invalid class name */
    public class AnonymousClass3 extends SharedSQLiteStatement {
        public AnonymousClass3(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$4, reason: invalid class name */
    public class AnonymousClass4 extends SharedSQLiteStatement {
        public AnonymousClass4(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$5, reason: invalid class name */
    public class AnonymousClass5 extends SharedSQLiteStatement {
        public AnonymousClass5(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$6, reason: invalid class name */
    public class AnonymousClass6 extends SharedSQLiteStatement {
        public AnonymousClass6(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$7, reason: invalid class name */
    public class AnonymousClass7 extends SharedSQLiteStatement {
        public AnonymousClass7(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$8, reason: invalid class name */
    public class AnonymousClass8 extends SharedSQLiteStatement {
        public AnonymousClass8(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    /* renamed from: androidx.work.impl.model.WorkSpecDao_Impl$9, reason: invalid class name */
    public class AnonymousClass9 extends SharedSQLiteStatement {
        public AnonymousClass9(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new AnonymousClass1(roomDatabase);
        this.__preparedStmtOfDelete = new AnonymousClass2(roomDatabase);
        this.__preparedStmtOfSetOutput = new AnonymousClass3(roomDatabase);
        this.__preparedStmtOfSetPeriodStartTime = new AnonymousClass4(roomDatabase);
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new AnonymousClass5(roomDatabase);
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new AnonymousClass6(roomDatabase);
        this.__preparedStmtOfMarkWorkSpecScheduled = new AnonymousClass7(roomDatabase);
        this.__preparedStmtOfResetScheduledState = new AnonymousClass8(roomDatabase);
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new AnonymousClass9(roomDatabase);
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

    public static /* synthetic */ RoomDatabase access$000(WorkSpecDao_Impl workSpecDao_Impl) {
        return workSpecDao_Impl.__db;
    }

    public static /* synthetic */ void access$100(WorkSpecDao_Impl workSpecDao_Impl, ArrayMap arrayMap) {
        workSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
    }

    public static /* synthetic */ void access$200(WorkSpecDao_Impl workSpecDao_Impl, ArrayMap arrayMap) {
        workSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap);
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDelete.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_start_time");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int i = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(columnIndexOrThrow9);
                int i2 = columnIndexOrThrow9;
                String string2 = cursorQuery.getString(columnIndexOrThrow11);
                int i3 = columnIndexOrThrow11;
                Constraints constraints = new Constraints();
                int i4 = columnIndexOrThrow;
                constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow)));
                constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow3) != 0);
                constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow4) != 0);
                constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                int i5 = columnIndexOrThrow2;
                int i6 = columnIndexOrThrow3;
                constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow6));
                constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow7));
                constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8)));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                int i7 = i;
                workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i7));
                i = i7;
                int i8 = columnIndexOrThrow15;
                workSpec.initialDelay = cursorQuery.getLong(i8);
                int i9 = columnIndexOrThrow13;
                int i10 = columnIndexOrThrow16;
                workSpec.intervalDuration = cursorQuery.getLong(i10);
                int i11 = columnIndexOrThrow4;
                int i12 = columnIndexOrThrow17;
                workSpec.flexDuration = cursorQuery.getLong(i12);
                int i13 = columnIndexOrThrow18;
                workSpec.runAttemptCount = cursorQuery.getInt(i13);
                int i14 = columnIndexOrThrow19;
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i14));
                columnIndexOrThrow17 = i12;
                int i15 = columnIndexOrThrow20;
                workSpec.backoffDelayDuration = cursorQuery.getLong(i15);
                int i16 = columnIndexOrThrow21;
                workSpec.periodStartTime = cursorQuery.getLong(i16);
                columnIndexOrThrow21 = i16;
                int i17 = columnIndexOrThrow22;
                workSpec.minimumRetentionDuration = cursorQuery.getLong(i17);
                int i18 = columnIndexOrThrow23;
                workSpec.scheduleRequestedAt = cursorQuery.getLong(i18);
                int i19 = columnIndexOrThrow24;
                workSpec.runInForeground = cursorQuery.getInt(i19) != 0;
                workSpec.constraints = constraints;
                arrayList.add(workSpec);
                columnIndexOrThrow23 = i18;
                columnIndexOrThrow24 = i19;
                columnIndexOrThrow2 = i5;
                columnIndexOrThrow13 = i9;
                columnIndexOrThrow15 = i8;
                columnIndexOrThrow16 = i10;
                columnIndexOrThrow18 = i13;
                columnIndexOrThrow9 = i2;
                columnIndexOrThrow11 = i3;
                columnIndexOrThrow = i4;
                columnIndexOrThrow22 = i17;
                columnIndexOrThrow3 = i6;
                columnIndexOrThrow20 = i15;
                columnIndexOrThrow4 = i11;
                columnIndexOrThrow19 = i14;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getAllWorkSpecIds() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getEligibleWorkForScheduling(int i) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        roomSQLiteQueryAcquire.bindLong(1, i);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    int i3 = columnIndexOrThrow9;
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    int i4 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i5 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                    int i6 = columnIndexOrThrow2;
                    int i7 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    int i8 = i2;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i8));
                    i2 = i8;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = cursorQuery.getLong(i9);
                    int i10 = columnIndexOrThrow12;
                    int i11 = columnIndexOrThrow16;
                    workSpec.intervalDuration = cursorQuery.getLong(i11);
                    int i12 = columnIndexOrThrow4;
                    int i13 = columnIndexOrThrow17;
                    workSpec.flexDuration = cursorQuery.getLong(i13);
                    int i14 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = cursorQuery.getInt(i14);
                    int i15 = columnIndexOrThrow19;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i15));
                    columnIndexOrThrow17 = i13;
                    int i16 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i16);
                    int i17 = columnIndexOrThrow21;
                    workSpec.periodStartTime = cursorQuery.getLong(i17);
                    columnIndexOrThrow21 = i17;
                    int i18 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i18);
                    int i19 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i19);
                    int i20 = columnIndexOrThrow24;
                    workSpec.runInForeground = cursorQuery.getInt(i20) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = i19;
                    columnIndexOrThrow24 = i20;
                    columnIndexOrThrow2 = i6;
                    columnIndexOrThrow12 = i10;
                    columnIndexOrThrow15 = i9;
                    columnIndexOrThrow16 = i11;
                    columnIndexOrThrow18 = i14;
                    columnIndexOrThrow9 = i3;
                    columnIndexOrThrow11 = i4;
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow22 = i18;
                    columnIndexOrThrow3 = i7;
                    columnIndexOrThrow20 = i16;
                    columnIndexOrThrow4 = i12;
                    columnIndexOrThrow19 = i15;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<Data> getInputsFromPrerequisites(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(Data.fromByteArray(cursorQuery.getBlob(0)));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRecentlyCompletedWork(long j) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    int i2 = columnIndexOrThrow9;
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    int i3 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i4 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                    int i5 = columnIndexOrThrow2;
                    int i6 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    int i7 = i;
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i7));
                    int i8 = columnIndexOrThrow15;
                    i = i7;
                    workSpec.initialDelay = cursorQuery.getLong(i8);
                    int i9 = columnIndexOrThrow12;
                    int i10 = columnIndexOrThrow16;
                    workSpec.intervalDuration = cursorQuery.getLong(i10);
                    int i11 = columnIndexOrThrow4;
                    int i12 = columnIndexOrThrow17;
                    workSpec.flexDuration = cursorQuery.getLong(i12);
                    int i13 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = cursorQuery.getInt(i13);
                    int i14 = columnIndexOrThrow19;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i14));
                    columnIndexOrThrow17 = i12;
                    int i15 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i15);
                    int i16 = columnIndexOrThrow21;
                    workSpec.periodStartTime = cursorQuery.getLong(i16);
                    columnIndexOrThrow21 = i16;
                    int i17 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i17);
                    int i18 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i18);
                    int i19 = columnIndexOrThrow24;
                    workSpec.runInForeground = cursorQuery.getInt(i19) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow2 = i5;
                    columnIndexOrThrow23 = i18;
                    columnIndexOrThrow24 = i19;
                    columnIndexOrThrow12 = i9;
                    columnIndexOrThrow15 = i8;
                    columnIndexOrThrow16 = i10;
                    columnIndexOrThrow18 = i13;
                    columnIndexOrThrow9 = i2;
                    columnIndexOrThrow11 = i3;
                    columnIndexOrThrow = i4;
                    columnIndexOrThrow22 = i17;
                    columnIndexOrThrow3 = i6;
                    columnIndexOrThrow20 = i15;
                    columnIndexOrThrow4 = i11;
                    columnIndexOrThrow19 = i14;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getRunningWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_start_time");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int i = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(columnIndexOrThrow9);
                int i2 = columnIndexOrThrow9;
                String string2 = cursorQuery.getString(columnIndexOrThrow11);
                int i3 = columnIndexOrThrow11;
                Constraints constraints = new Constraints();
                int i4 = columnIndexOrThrow;
                constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow)));
                constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow3) != 0);
                constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow4) != 0);
                constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                int i5 = columnIndexOrThrow2;
                int i6 = columnIndexOrThrow3;
                constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow6));
                constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow7));
                constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8)));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                int i7 = i;
                workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i7));
                i = i7;
                int i8 = columnIndexOrThrow15;
                workSpec.initialDelay = cursorQuery.getLong(i8);
                int i9 = columnIndexOrThrow13;
                int i10 = columnIndexOrThrow16;
                workSpec.intervalDuration = cursorQuery.getLong(i10);
                int i11 = columnIndexOrThrow4;
                int i12 = columnIndexOrThrow17;
                workSpec.flexDuration = cursorQuery.getLong(i12);
                int i13 = columnIndexOrThrow18;
                workSpec.runAttemptCount = cursorQuery.getInt(i13);
                int i14 = columnIndexOrThrow19;
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i14));
                columnIndexOrThrow17 = i12;
                int i15 = columnIndexOrThrow20;
                workSpec.backoffDelayDuration = cursorQuery.getLong(i15);
                int i16 = columnIndexOrThrow21;
                workSpec.periodStartTime = cursorQuery.getLong(i16);
                columnIndexOrThrow21 = i16;
                int i17 = columnIndexOrThrow22;
                workSpec.minimumRetentionDuration = cursorQuery.getLong(i17);
                int i18 = columnIndexOrThrow23;
                workSpec.scheduleRequestedAt = cursorQuery.getLong(i18);
                int i19 = columnIndexOrThrow24;
                workSpec.runInForeground = cursorQuery.getInt(i19) != 0;
                workSpec.constraints = constraints;
                arrayList.add(workSpec);
                columnIndexOrThrow23 = i18;
                columnIndexOrThrow24 = i19;
                columnIndexOrThrow2 = i5;
                columnIndexOrThrow13 = i9;
                columnIndexOrThrow15 = i8;
                columnIndexOrThrow16 = i10;
                columnIndexOrThrow18 = i13;
                columnIndexOrThrow9 = i2;
                columnIndexOrThrow11 = i3;
                columnIndexOrThrow = i4;
                columnIndexOrThrow22 = i17;
                columnIndexOrThrow3 = i6;
                columnIndexOrThrow20 = i15;
                columnIndexOrThrow4 = i11;
                columnIndexOrThrow19 = i14;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec> getScheduledWork() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_start_time");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
            int i = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(columnIndexOrThrow9);
                int i2 = columnIndexOrThrow9;
                String string2 = cursorQuery.getString(columnIndexOrThrow11);
                int i3 = columnIndexOrThrow11;
                Constraints constraints = new Constraints();
                int i4 = columnIndexOrThrow;
                constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow)));
                constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow3) != 0);
                constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow4) != 0);
                constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                int i5 = columnIndexOrThrow2;
                int i6 = columnIndexOrThrow3;
                constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow6));
                constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow7));
                constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8)));
                WorkSpec workSpec = new WorkSpec(string, string2);
                workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                int i7 = i;
                workSpec.output = Data.fromByteArray(cursorQuery.getBlob(i7));
                i = i7;
                int i8 = columnIndexOrThrow15;
                workSpec.initialDelay = cursorQuery.getLong(i8);
                int i9 = columnIndexOrThrow13;
                int i10 = columnIndexOrThrow16;
                workSpec.intervalDuration = cursorQuery.getLong(i10);
                int i11 = columnIndexOrThrow4;
                int i12 = columnIndexOrThrow17;
                workSpec.flexDuration = cursorQuery.getLong(i12);
                int i13 = columnIndexOrThrow18;
                workSpec.runAttemptCount = cursorQuery.getInt(i13);
                int i14 = columnIndexOrThrow19;
                workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i14));
                columnIndexOrThrow17 = i12;
                int i15 = columnIndexOrThrow20;
                workSpec.backoffDelayDuration = cursorQuery.getLong(i15);
                int i16 = columnIndexOrThrow21;
                workSpec.periodStartTime = cursorQuery.getLong(i16);
                columnIndexOrThrow21 = i16;
                int i17 = columnIndexOrThrow22;
                workSpec.minimumRetentionDuration = cursorQuery.getLong(i17);
                int i18 = columnIndexOrThrow23;
                workSpec.scheduleRequestedAt = cursorQuery.getLong(i18);
                int i19 = columnIndexOrThrow24;
                workSpec.runInForeground = cursorQuery.getInt(i19) != 0;
                workSpec.constraints = constraints;
                arrayList.add(workSpec);
                columnIndexOrThrow23 = i18;
                columnIndexOrThrow24 = i19;
                columnIndexOrThrow2 = i5;
                columnIndexOrThrow13 = i9;
                columnIndexOrThrow15 = i8;
                columnIndexOrThrow16 = i10;
                columnIndexOrThrow18 = i13;
                columnIndexOrThrow9 = i2;
                columnIndexOrThrow11 = i3;
                columnIndexOrThrow = i4;
                columnIndexOrThrow22 = i17;
                columnIndexOrThrow3 = i6;
                columnIndexOrThrow20 = i15;
                columnIndexOrThrow4 = i11;
                columnIndexOrThrow19 = i14;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkInfo.State getState(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            return cursorQuery.moveToFirst() ? WorkTypeConverters.intToState(cursorQuery.getInt(0)) : null;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<String> getUnfinishedWorkWithTag(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(cursorQuery.getString(0));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(String str) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                    constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec2 = new WorkSpec(string, string2);
                    workSpec2.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec2.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec2.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    workSpec2.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow14));
                    workSpec2.initialDelay = cursorQuery.getLong(columnIndexOrThrow15);
                    workSpec2.intervalDuration = cursorQuery.getLong(columnIndexOrThrow16);
                    workSpec2.flexDuration = cursorQuery.getLong(columnIndexOrThrow17);
                    workSpec2.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow18);
                    workSpec2.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(columnIndexOrThrow19));
                    workSpec2.backoffDelayDuration = cursorQuery.getLong(columnIndexOrThrow20);
                    workSpec2.periodStartTime = cursorQuery.getLong(columnIndexOrThrow21);
                    workSpec2.minimumRetentionDuration = cursorQuery.getLong(columnIndexOrThrow22);
                    workSpec2.scheduleRequestedAt = cursorQuery.getLong(columnIndexOrThrow23);
                    workSpec2.runInForeground = cursorQuery.getInt(columnIndexOrThrow24) != 0;
                    workSpec2.constraints = constraints;
                    workSpec = workSpec2;
                } else {
                    workSpec = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.f39id = cursorQuery.getString(columnIndexOrThrow);
                idAndState.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec[] getWorkSpecs(List<String> list) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT ");
        sbNewStringBuilder.append("*");
        sbNewStringBuilder.append(" FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "required_network_type");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_charging");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_device_idle");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_battery_not_low");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "requires_storage_not_low");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_content_update_delay");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "trigger_max_content_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "content_uri_triggers");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "worker_class_name");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input_merger_class_name");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "input");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "initial_delay");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "interval_duration");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "flex_duration");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_policy");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "backoff_delay_duration");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "period_start_time");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "minimum_retention_duration");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schedule_requested_at");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_in_foreground");
                WorkSpec[] workSpecArr = new WorkSpec[cursorQuery.getCount()];
                int i2 = 0;
                while (cursorQuery.moveToNext()) {
                    WorkSpec[] workSpecArr2 = workSpecArr;
                    String string = cursorQuery.getString(columnIndexOrThrow9);
                    int i3 = columnIndexOrThrow9;
                    String string2 = cursorQuery.getString(columnIndexOrThrow11);
                    int i4 = columnIndexOrThrow11;
                    Constraints constraints = new Constraints();
                    int i5 = columnIndexOrThrow;
                    constraints.setRequiredNetworkType(WorkTypeConverters.intToNetworkType(cursorQuery.getInt(columnIndexOrThrow)));
                    constraints.setRequiresCharging(cursorQuery.getInt(columnIndexOrThrow2) != 0);
                    constraints.setRequiresDeviceIdle(cursorQuery.getInt(columnIndexOrThrow3) != 0);
                    constraints.setRequiresBatteryNotLow(cursorQuery.getInt(columnIndexOrThrow4) != 0);
                    constraints.setRequiresStorageNotLow(cursorQuery.getInt(columnIndexOrThrow5) != 0);
                    int i6 = columnIndexOrThrow2;
                    int i7 = columnIndexOrThrow3;
                    constraints.setTriggerContentUpdateDelay(cursorQuery.getLong(columnIndexOrThrow6));
                    constraints.setTriggerMaxContentDelay(cursorQuery.getLong(columnIndexOrThrow7));
                    constraints.setContentUriTriggers(WorkTypeConverters.byteArrayToContentUriTriggers(cursorQuery.getBlob(columnIndexOrThrow8)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = cursorQuery.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow14));
                    int i8 = columnIndexOrThrow14;
                    int i9 = columnIndexOrThrow15;
                    workSpec.initialDelay = cursorQuery.getLong(i9);
                    columnIndexOrThrow15 = i9;
                    int i10 = columnIndexOrThrow16;
                    workSpec.intervalDuration = cursorQuery.getLong(i10);
                    int i11 = columnIndexOrThrow12;
                    int i12 = columnIndexOrThrow17;
                    workSpec.flexDuration = cursorQuery.getLong(i12);
                    int i13 = columnIndexOrThrow18;
                    workSpec.runAttemptCount = cursorQuery.getInt(i13);
                    int i14 = columnIndexOrThrow19;
                    workSpec.backoffPolicy = WorkTypeConverters.intToBackoffPolicy(cursorQuery.getInt(i14));
                    columnIndexOrThrow17 = i12;
                    int i15 = columnIndexOrThrow20;
                    workSpec.backoffDelayDuration = cursorQuery.getLong(i15);
                    int i16 = columnIndexOrThrow21;
                    workSpec.periodStartTime = cursorQuery.getLong(i16);
                    columnIndexOrThrow21 = i16;
                    int i17 = columnIndexOrThrow22;
                    workSpec.minimumRetentionDuration = cursorQuery.getLong(i17);
                    columnIndexOrThrow22 = i17;
                    int i18 = columnIndexOrThrow23;
                    workSpec.scheduleRequestedAt = cursorQuery.getLong(i18);
                    int i19 = columnIndexOrThrow24;
                    workSpec.runInForeground = cursorQuery.getInt(i19) != 0;
                    workSpec.constraints = constraints;
                    workSpecArr2[i2] = workSpec;
                    i2++;
                    columnIndexOrThrow23 = i18;
                    columnIndexOrThrow24 = i19;
                    columnIndexOrThrow14 = i8;
                    columnIndexOrThrow2 = i6;
                    workSpecArr = workSpecArr2;
                    columnIndexOrThrow9 = i3;
                    columnIndexOrThrow11 = i4;
                    columnIndexOrThrow3 = i7;
                    columnIndexOrThrow = i5;
                    columnIndexOrThrow20 = i15;
                    columnIndexOrThrow12 = i11;
                    columnIndexOrThrow16 = i10;
                    columnIndexOrThrow18 = i13;
                    columnIndexOrThrow19 = i14;
                }
                WorkSpec[] workSpecArr3 = workSpecArr;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return workSpecArr3;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id=?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            WorkSpec.WorkInfoPojo workInfoPojo = null;
            Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (cursorQuery.moveToNext()) {
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string2 = cursorQuery.getString(columnIndexOrThrow);
                        if (arrayMap2.get(string2) == null) {
                            arrayMap2.put(string2, new ArrayList<>());
                        }
                    }
                }
                cursorQuery.moveToPosition(-1);
                __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                if (cursorQuery.moveToFirst()) {
                    ArrayList<String> arrayList = !cursorQuery.isNull(columnIndexOrThrow) ? arrayMap.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList2 = cursorQuery.isNull(columnIndexOrThrow) ? null : arrayMap2.get(cursorQuery.getString(columnIndexOrThrow));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo2 = new WorkSpec.WorkInfoPojo();
                    workInfoPojo2.f40id = cursorQuery.getString(columnIndexOrThrow);
                    workInfoPojo2.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workInfoPojo2.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                    workInfoPojo2.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow4);
                    workInfoPojo2.tags = arrayList;
                    workInfoPojo2.progress = arrayList2;
                    workInfoPojo = workInfoPojo2;
                }
                this.__db.setTransactionSuccessful();
                return workInfoPojo;
            } finally {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (cursorQuery.moveToNext()) {
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string2 = cursorQuery.getString(columnIndexOrThrow);
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
                    ArrayList<String> arrayList2 = !cursorQuery.isNull(columnIndexOrThrow) ? arrayMap.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = !cursorQuery.isNull(columnIndexOrThrow) ? arrayMap2.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.f40id = cursorQuery.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList2;
                    workInfoPojo.progress = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                this.__db.setTransactionSuccessful();
                return arrayList;
            } finally {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (cursorQuery.moveToNext()) {
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string2 = cursorQuery.getString(columnIndexOrThrow);
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
                    ArrayList<String> arrayList2 = !cursorQuery.isNull(columnIndexOrThrow) ? arrayMap.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = !cursorQuery.isNull(columnIndexOrThrow) ? arrayMap2.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.f40id = cursorQuery.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList2;
                    workInfoPojo.progress = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                this.__db.setTransactionSuccessful();
                return arrayList;
            } finally {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, true, null);
            try {
                int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, ModelAuditLogEntry.CHANGE_KEY_ID);
                int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "state");
                int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "output");
                int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "run_attempt_count");
                ArrayMap<String, ArrayList<String>> arrayMap = new ArrayMap<>();
                ArrayMap<String, ArrayList<Data>> arrayMap2 = new ArrayMap<>();
                while (cursorQuery.moveToNext()) {
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string = cursorQuery.getString(columnIndexOrThrow);
                        if (arrayMap.get(string) == null) {
                            arrayMap.put(string, new ArrayList<>());
                        }
                    }
                    if (!cursorQuery.isNull(columnIndexOrThrow)) {
                        String string2 = cursorQuery.getString(columnIndexOrThrow);
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
                    ArrayList<String> arrayList2 = !cursorQuery.isNull(columnIndexOrThrow) ? arrayMap.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    ArrayList<Data> arrayList3 = !cursorQuery.isNull(columnIndexOrThrow) ? arrayMap2.get(cursorQuery.getString(columnIndexOrThrow)) : null;
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList<>();
                    }
                    WorkSpec.WorkInfoPojo workInfoPojo = new WorkSpec.WorkInfoPojo();
                    workInfoPojo.f40id = cursorQuery.getString(columnIndexOrThrow);
                    workInfoPojo.state = WorkTypeConverters.intToState(cursorQuery.getInt(columnIndexOrThrow2));
                    workInfoPojo.output = Data.fromByteArray(cursorQuery.getBlob(columnIndexOrThrow3));
                    workInfoPojo.runAttemptCount = cursorQuery.getInt(columnIndexOrThrow4);
                    workInfoPojo.tags = arrayList2;
                    workInfoPojo.progress = arrayList3;
                    arrayList.add(workInfoPojo);
                }
                this.__db.setTransactionSuccessful();
                return arrayList;
            } finally {
                cursorQuery.close();
                roomSQLiteQueryAcquire.release();
            }
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(sbNewStringBuilder, size);
        sbNewStringBuilder.append(")");
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire(sbNewStringBuilder.toString(), size + 0);
        int i = 1;
        for (String str : list) {
            if (str == null) {
                roomSQLiteQueryAcquire.bindNull(i);
            } else {
                roomSQLiteQueryAcquire.bindString(i, str);
            }
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new AnonymousClass10(roomSQLiteQueryAcquire));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new AnonymousClass12(roomSQLiteQueryAcquire));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count FROM workspec WHERE id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new AnonymousClass11(roomSQLiteQueryAcquire));
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert((EntityInsertionAdapter<WorkSpec>) workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setOutput(String str, Data data) throws Throwable {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetOutput.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public void setPeriodStartTime(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfSetPeriodStartTime.acquire();
        supportSQLiteStatementAcquire.bindLong(1, j);
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(2);
        } else {
            supportSQLiteStatementAcquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetPeriodStartTime.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // androidx.work.impl.model.WorkSpecDao
    public int setState(WorkInfo.State state, String... strArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
        sbNewStringBuilder.append("UPDATE workspec SET state=");
        sbNewStringBuilder.append("?");
        sbNewStringBuilder.append(" WHERE id IN (");
        StringUtil.appendPlaceholders(sbNewStringBuilder, strArr.length);
        sbNewStringBuilder.append(")");
        SupportSQLiteStatement supportSQLiteStatementCompileStatement = this.__db.compileStatement(sbNewStringBuilder.toString());
        supportSQLiteStatementCompileStatement.bindLong(1, WorkTypeConverters.stateToInt(state));
        int i = 2;
        for (String str : strArr) {
            if (str == null) {
                supportSQLiteStatementCompileStatement.bindNull(i);
            } else {
                supportSQLiteStatementCompileStatement.bindString(i, str);
            }
            i++;
        }
        this.__db.beginTransaction();
        try {
            int iExecuteUpdateDelete = supportSQLiteStatementCompileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return iExecuteUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }
}
