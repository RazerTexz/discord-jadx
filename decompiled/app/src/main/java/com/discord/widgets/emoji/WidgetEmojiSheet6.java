package com.discord.widgets.emoji;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.emoji.WidgetEmojiSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEmojiSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/fragment/app/FragmentActivity;", "fragmentActivity", "", "invoke", "(Landroidx/fragment/app/FragmentActivity;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.emoji.WidgetEmojiSheet$Companion$enqueueNotice$showEmojiSheetNotice$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEmojiSheet6 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ EmojiNode.EmojiIdAndType $emojiIdAndType;
    public final /* synthetic */ String $noticeName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiSheet6(EmojiNode.EmojiIdAndType emojiIdAndType, String str) {
        super(1);
        this.$emojiIdAndType = emojiIdAndType;
        this.$noticeName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        WidgetEmojiSheet.Companion companion = WidgetEmojiSheet.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        companion.show(supportFragmentManager, this.$emojiIdAndType);
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), this.$noticeName, 0L, 2, null);
        return true;
    }
}
