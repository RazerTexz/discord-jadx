package com.discord.widgets.user.usersheet;

import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetUserSheet.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel;", "invoke", "()Lcom/discord/widgets/user/usersheet/WidgetUserSheetViewModel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserSheet$viewModel$2 extends Lambda implements Function0<WidgetUserSheetViewModel> {
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$viewModel$2(WidgetUserSheet widgetUserSheet) {
        super(0);
        this.this$0 = widgetUserSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetUserSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetUserSheetViewModel invoke() {
        long j = WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_USER_ID");
        long j2 = WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_CHANNEL_ID");
        long j3 = WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getLong("ARG_GUILD_ID");
        boolean z2 = WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getBoolean("ARG_IS_VOICE_CONTEXT");
        Serializable serializable = WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable("ARG_STREAM_PREVIEW_CLICK_BEHAVIOR");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.widgets.user.usersheet.WidgetUserSheet.StreamPreviewClickBehavior");
        WidgetUserSheet.StreamPreviewClickBehavior streamPreviewClickBehavior = (WidgetUserSheet.StreamPreviewClickBehavior) serializable;
        return new WidgetUserSheetViewModel(j, j2, Long.valueOf(j3), WidgetUserSheet.access$getArgumentsOrDefault$p(this.this$0).getString("ARG_FRIEND_TOKEN"), z2, null, streamPreviewClickBehavior, null, null, null, null, null, null, null, null, 32672, null);
    }
}
