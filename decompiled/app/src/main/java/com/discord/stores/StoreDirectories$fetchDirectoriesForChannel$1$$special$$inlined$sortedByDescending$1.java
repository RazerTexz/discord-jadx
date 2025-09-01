package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.directory.DirectoryEntryGuild;
import d0.u.a;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: Comparisons.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreDirectories$fetchDirectoriesForChannel$1$$special$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Integer approximateMemberCount = ((DirectoryEntryGuild) t2).getGuild().getApproximateMemberCount();
        Integer numValueOf = Integer.valueOf(approximateMemberCount != null ? approximateMemberCount.intValue() : 0);
        Integer approximateMemberCount2 = ((DirectoryEntryGuild) t).getGuild().getApproximateMemberCount();
        return a.compareValues(numValueOf, Integer.valueOf(approximateMemberCount2 != null ? approximateMemberCount2.intValue() : 0));
    }
}
