package com.discord.models.hubs;

import d0.t.Collections2;
import java.util.List;
import kotlin.Metadata;

/* compiled from: DirectoryEntryCategory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003¨\u0006\u0005"}, d2 = {"", "Lcom/discord/models/hubs/DirectoryEntryCategory;", "HUB_CATEGORIES", "Ljava/util/List;", "HQ_DIRECTORY_CATEGORIES", "app_productionGoogleRelease"}, k = 2, mv = {1, 4, 2})
/* renamed from: com.discord.models.hubs.DirectoryEntryCategoryKt, reason: use source file name */
/* loaded from: classes.dex */
public final class DirectoryEntryCategory2 {
    private static final List<DirectoryEntryCategory> HUB_CATEGORIES = Collections2.listOf((Object[]) new DirectoryEntryCategory[]{DirectoryEntryCategory.SchoolClub, DirectoryEntryCategory.Class, DirectoryEntryCategory.StudySocial, DirectoryEntryCategory.Misc});
    private static final List<DirectoryEntryCategory> HQ_DIRECTORY_CATEGORIES = Collections2.listOf((Object[]) new DirectoryEntryCategory[]{DirectoryEntryCategory.HQSocial, DirectoryEntryCategory.HQErgs, DirectoryEntryCategory.HQMisc, DirectoryEntryCategory.HQArchives});

    public static final /* synthetic */ List access$getHQ_DIRECTORY_CATEGORIES$p() {
        return HQ_DIRECTORY_CATEGORIES;
    }

    public static final /* synthetic */ List access$getHUB_CATEGORIES$p() {
        return HUB_CATEGORIES;
    }
}
