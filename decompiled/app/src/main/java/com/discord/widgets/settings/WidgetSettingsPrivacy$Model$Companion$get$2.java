package com.discord.widgets.settings;

import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.widgets.settings.WidgetSettingsPrivacy;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function7;

/* compiled from: WidgetSettingsPrivacy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Lcom/discord/models/user/MeUser;", "p1", "", "p2", "", "p3", "Lcom/discord/models/domain/ModelUserSettings$FriendSourceFlags;", "p4", "Lcom/discord/api/connectedaccounts/ConnectedAccount;", "p5", "Lcom/discord/models/experiments/domain/Experiment;", "p6", "p7", "Lcom/discord/widgets/settings/WidgetSettingsPrivacy$LocalState;", "invoke", "(Lcom/discord/models/user/MeUser;IZLcom/discord/models/domain/ModelUserSettings$FriendSourceFlags;Lcom/discord/api/connectedaccounts/ConnectedAccount;Lcom/discord/models/experiments/domain/Experiment;I)Lcom/discord/widgets/settings/WidgetSettingsPrivacy$LocalState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsPrivacy$Model$Companion$get$2 extends FunctionReferenceImpl implements Function7<MeUser, Integer, Boolean, ModelUserSettings.FriendSourceFlags, ConnectedAccount, Experiment, Integer, WidgetSettingsPrivacy.LocalState> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$2 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$2();

    public WidgetSettingsPrivacy$Model$Companion$get$2() {
        super(7, WidgetSettingsPrivacy.LocalState.class, "<init>", "<init>(Lcom/discord/models/user/MeUser;IZLcom/discord/models/domain/ModelUserSettings$FriendSourceFlags;Lcom/discord/api/connectedaccounts/ConnectedAccount;Lcom/discord/models/experiments/domain/Experiment;I)V", 0);
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ WidgetSettingsPrivacy.LocalState invoke(MeUser meUser, Integer num, Boolean bool, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, Integer num2) {
        return invoke(meUser, num.intValue(), bool.booleanValue(), friendSourceFlags, connectedAccount, experiment, num2.intValue());
    }

    public final WidgetSettingsPrivacy.LocalState invoke(MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, int i2) {
        Intrinsics3.checkNotNullParameter(meUser, "p1");
        return new WidgetSettingsPrivacy.LocalState(meUser, i, z2, friendSourceFlags, connectedAccount, experiment, i2);
    }
}
