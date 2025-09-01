package com.discord.widgets.user;

import b.a.d.AppViewModel;
import com.discord.widgets.user.WidgetUserMentions;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: WidgetUserMentionsViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/user/WidgetUserMentionsViewModel;", "Lb/a/d/d0;", "", "Lcom/discord/widgets/user/WidgetUserMentions$Model;", "model", "Lcom/discord/widgets/user/WidgetUserMentions$Model;", "getModel$app_productionGoogleRelease", "()Lcom/discord/widgets/user/WidgetUserMentions$Model;", "setModel$app_productionGoogleRelease", "(Lcom/discord/widgets/user/WidgetUserMentions$Model;)V", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetUserMentionsViewModel extends AppViewModel<Unit> {
    private WidgetUserMentions.Model model;

    public WidgetUserMentionsViewModel() {
        super(null, 1, null);
    }

    /* renamed from: getModel$app_productionGoogleRelease, reason: from getter */
    public final WidgetUserMentions.Model getModel() {
        return this.model;
    }

    public final void setModel$app_productionGoogleRelease(WidgetUserMentions.Model model) {
        this.model = model;
    }
}
