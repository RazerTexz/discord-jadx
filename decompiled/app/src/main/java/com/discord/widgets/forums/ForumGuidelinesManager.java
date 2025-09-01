package com.discord.widgets.forums;

import android.content.SharedPreferences;
import com.discord.utilities.cache.SharedPreferenceExtensions;
import com.discord.utilities.cache.SharedPreferencesProvider;
import d0.g0.StringNumberConversions;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: ForumGuidelinesManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010#\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\tJ\u0019\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00072\n\u0010\n\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/forums/ForumGuidelinesManager;", "", "", "", "Lcom/discord/primitives/ChannelId;", "getFromCache", "()Ljava/util/Set;", "", "updateCache", "()V", "channelId", "", "hasSeenGuidelines", "(J)Z", "markGuidelinesSeen", "(J)V", "seenChannelIds", "Ljava/util/Set;", "<init>", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ForumGuidelinesManager {
    public static final ForumGuidelinesManager INSTANCE;
    private static final Set<Long> seenChannelIds;

    static {
        ForumGuidelinesManager forumGuidelinesManager = new ForumGuidelinesManager();
        INSTANCE = forumGuidelinesManager;
        seenChannelIds = forumGuidelinesManager.getFromCache();
    }

    private ForumGuidelinesManager() {
    }

    private final Set<Long> getFromCache() {
        Set stringSetNonNull$default = SharedPreferenceExtensions.getStringSetNonNull$default(SharedPreferencesProvider.INSTANCE.get(), "CACHE_KEY_USER_VIEWED_FORUM_GUIDELINES", null, 2, null);
        ArrayList arrayList = new ArrayList();
        Iterator it = stringSetNonNull$default.iterator();
        while (it.hasNext()) {
            Long longOrNull = StringNumberConversions.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(longOrNull);
            }
        }
        return _Collections.toMutableSet(arrayList);
    }

    private final void updateCache() {
        Set<Long> set = seenChannelIds;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        Set<String> set2 = _Collections.toSet(arrayList);
        SharedPreferences.Editor editorEdit = SharedPreferencesProvider.INSTANCE.get().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putStringSet("CACHE_KEY_USER_VIEWED_FORUM_GUIDELINES", set2);
        editorEdit.apply();
    }

    public final boolean hasSeenGuidelines(long channelId) {
        return seenChannelIds.contains(Long.valueOf(channelId));
    }

    public final void markGuidelinesSeen(long channelId) {
        seenChannelIds.add(Long.valueOf(channelId));
        updateCache();
    }
}
