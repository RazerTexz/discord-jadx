package com.discord.models.hubs;

import android.content.Context;
import androidx.annotation.StringRes;
import com.discord.R;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DirectoryEntryCategory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B%\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bj\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/discord/models/hubs/DirectoryEntryCategory;", "", "Landroid/content/Context;", "context", "", "getTitle", "(Landroid/content/Context;)Ljava/lang/String;", "", "key", "I", "getKey", "()I", "titleRes", "getTitleRes", "idealSize", "getIdealSize", "<init>", "(Ljava/lang/String;IIII)V", "Companion", "Home", "Uncategorized", "SchoolClub", "Class", "StudySocial", "SubjectMajor", "Misc", "HQSocial", "HQErgs", "HQMisc", "HQArchives", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public enum DirectoryEntryCategory {
    Home(-1, R.string.directory_category_all, 70),
    Uncategorized(0, R.string.uncategorized, 0, 4, null),
    SchoolClub(1, R.string.directory_category_school_club, 100),
    Class(2, R.string.directory_category_class, 0, 4, null),
    StudySocial(3, R.string.directory_category_study_social, 50),
    SubjectMajor(4, R.string.directory_category_subject_major, 0, 4, null),
    Misc(5, R.string.directory_category_miscellaneous, 0, 4, null),
    HQSocial(1, R.string.directory_category_internal_1, 0, 4, null),
    HQErgs(2, R.string.directory_category_internal_2, 0, 4, null),
    HQMisc(3, R.string.directory_category_internal_3, 0, 4, null),
    HQArchives(5, R.string.directory_category_internal_5, 0, 4, null);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int idealSize;
    private final int key;
    private final int titleRes;

    /* compiled from: DirectoryEntryCategory.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/discord/models/hubs/DirectoryEntryCategory$Companion;", "", "", "key", "", "isHQDirectoryChannel", "Lcom/discord/models/hubs/DirectoryEntryCategory;", "findByKey", "(IZ)Lcom/discord/models/hubs/DirectoryEntryCategory;", "", "getCategories", "(Z)Ljava/util/List;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final DirectoryEntryCategory findByKey(int key, boolean isHQDirectoryChannel) {
            Object next;
            Iterator<T> it = getCategories(isHQDirectoryChannel).iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((DirectoryEntryCategory) next).getKey() == key) {
                    break;
                }
            }
            DirectoryEntryCategory directoryEntryCategory = (DirectoryEntryCategory) next;
            return directoryEntryCategory != null ? directoryEntryCategory : DirectoryEntryCategory.Uncategorized;
        }

        public final List<DirectoryEntryCategory> getCategories(boolean isHQDirectoryChannel) {
            return isHQDirectoryChannel ? DirectoryEntryCategory2.access$getHQ_DIRECTORY_CATEGORIES$p() : DirectoryEntryCategory2.access$getHUB_CATEGORIES$p();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    DirectoryEntryCategory(int i, @StringRes int i2, int i3) {
        this.key = i;
        this.titleRes = i2;
        this.idealSize = i3;
    }

    public final int getIdealSize() {
        return this.idealSize;
    }

    public final int getKey() {
        return this.key;
    }

    public final String getTitle(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        String string = context.getString(this.titleRes);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(titleRes)");
        return string;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    /* synthetic */ DirectoryEntryCategory(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? Integer.MAX_VALUE : i3);
    }
}
