package com.discord.utilities;

import androidx.core.content.pm.ShortcutInfoCompat;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: ShareUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/core/content/pm/ShortcutInfoCompat;", "kotlin.jvm.PlatformType", "shortcutInfoCompat", "", "invoke", "(Landroidx/core/content/pm/ShortcutInfoCompat;)J", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2 extends Lambda implements Function1<ShortcutInfoCompat, Long> {
    public static final ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2 INSTANCE = new ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2();

    public ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(ShortcutInfoCompat shortcutInfoCompat) {
        return Long.valueOf(invoke2(shortcutInfoCompat));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(ShortcutInfoCompat shortcutInfoCompat) {
        Intrinsics3.checkNotNullExpressionValue(shortcutInfoCompat, "shortcutInfoCompat");
        String id2 = shortcutInfoCompat.getId();
        Intrinsics3.checkNotNullExpressionValue(id2, "shortcutInfoCompat.id");
        return Long.parseLong(id2);
    }
}
