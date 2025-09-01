package androidx.core.database.sqlite;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.InlineMarker;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: SQLiteDatabase.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u0004H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroid/database/sqlite/SQLiteDatabase;", "", "exclusive", "Lkotlin/Function1;", "body", "transaction", "(Landroid/database/sqlite/SQLiteDatabase;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 5, 1})
/* renamed from: androidx.core.database.sqlite.SQLiteDatabaseKt, reason: use source file name */
/* loaded from: classes.dex */
public final class SQLiteDatabase {
    public static final <T> T transaction(android.database.sqlite.SQLiteDatabase sQLiteDatabase, boolean z2, Function1<? super android.database.sqlite.SQLiteDatabase, ? extends T> function1) {
        Intrinsics3.checkNotNullParameter(sQLiteDatabase, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "body");
        if (z2) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T tInvoke = function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return tInvoke;
        } finally {
            InlineMarker.finallyStart(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ Object transaction$default(android.database.sqlite.SQLiteDatabase sQLiteDatabase, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        Intrinsics3.checkNotNullParameter(sQLiteDatabase, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "body");
        if (z2) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object objInvoke = function1.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return objInvoke;
        } finally {
            InlineMarker.finallyStart(1);
            sQLiteDatabase.endTransaction();
            InlineMarker.finallyEnd(1);
        }
    }
}
