package com.discord.utilities.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.directories.DirectoryEntryData;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: DirectoryUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a%\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0011\u0010\r\u001a\u00020\f*\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\"\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010\"\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010\"\u0016\u0010\u0013\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010\"\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010¨\u0006\u0015"}, d2 = {"", "Lcom/discord/widgets/directories/DirectoryEntryData;", "", "numberToChoose", "sortByRanking", "(Ljava/util/List;I)Ljava/util/List;", "sortByAdded", "(Ljava/util/List;)Ljava/util/List;", "idealSize", "rank", "(Ljava/util/List;Ljava/lang/Integer;)Ljava/util/List;", "Lcom/discord/api/directory/DirectoryEntryGuild;", "", "hasMinimumMemberCount", "(Lcom/discord/api/directory/DirectoryEntryGuild;)Z", "MAX_RECOMMENDATION_COUNT", "I", "MAXIMUM_SIZE", "MINIMUM_SIZE", "MINIMUM_MEMBER_COUNT", "MAX_HOME_CATEGORY_COUNT", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.directories.DirectoryUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class DirectoryUtils2 {
    private static final int MAXIMUM_SIZE = 200;
    public static final int MAX_HOME_CATEGORY_COUNT = 5;
    public static final int MAX_RECOMMENDATION_COUNT = 5;
    private static final int MINIMUM_MEMBER_COUNT = 5;
    private static final int MINIMUM_SIZE = 5;

    public static final boolean hasMinimumMemberCount(DirectoryEntryGuild directoryEntryGuild) {
        Intrinsics3.checkNotNullParameter(directoryEntryGuild, "$this$hasMinimumMemberCount");
        Integer approximateMemberCount = directoryEntryGuild.getGuild().getApproximateMemberCount();
        return (approximateMemberCount != null ? approximateMemberCount.intValue() : 0) >= 5;
    }

    public static final List<DirectoryEntryData> rank(List<DirectoryEntryData> list, Integer num) {
        Intrinsics3.checkNotNullParameter(list, "$this$rank");
        return _Collections.sortedWith(list, new DirectoryUtilsKt$rank$$inlined$sortedBy$1(num));
    }

    public static /* synthetic */ List rank$default(List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return rank(list, num);
    }

    public static final List<DirectoryEntryData> sortByAdded(List<DirectoryEntryData> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$sortByAdded");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            DirectoryEntryData directoryEntryData = (DirectoryEntryData) obj;
            if (Intrinsics3.areEqual(directoryEntryData.getEntry().getGuild().getFeaturableInDirectory(), Boolean.TRUE) && hasMinimumMemberCount(directoryEntryData.getEntry())) {
                arrayList.add(obj);
            }
        }
        return _Collections.take(_Collections.sortedWith(arrayList, new DirectoryUtilsKt$sortByAdded$$inlined$sortedByDescending$1()), 5);
    }

    public static final List<DirectoryEntryData> sortByRanking(List<DirectoryEntryData> list, int i) {
        Intrinsics3.checkNotNullParameter(list, "$this$sortByRanking");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics3.areEqual(((DirectoryEntryData) obj).getEntry().getGuild().getFeaturableInDirectory(), Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        return _Collections.take(rank$default(arrayList, null, 1, null), i);
    }
}
