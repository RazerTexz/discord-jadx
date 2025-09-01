package com.discord.widgets.nux;

import com.discord.R;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.guilds.create.StockGuildTemplate;
import com.discord.widgets.guilds.create.WidgetCreationIntent;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import com.discord.widgets.nux.GuildTemplatesAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: WidgetGuildTemplates.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/discord/widgets/nux/WidgetGuildTemplates$adapter$1", "Lcom/discord/widgets/nux/GuildTemplatesAdapter$Callbacks;", "Lcom/discord/widgets/nux/GuildTemplate;", "guildTemplate", "", "onTemplateClick", "(Lcom/discord/widgets/nux/GuildTemplate;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.nux.WidgetGuildTemplates$adapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildTemplates4 implements GuildTemplatesAdapter.Callbacks {
    public final /* synthetic */ WidgetGuildTemplates this$0;

    public WidgetGuildTemplates4(WidgetGuildTemplates widgetGuildTemplates) {
        this.this$0 = widgetGuildTemplates;
    }

    @Override // com.discord.widgets.nux.GuildTemplatesAdapter.Callbacks
    public void onTemplateClick(GuildTemplates guildTemplate) {
        Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
        WidgetGuildCreate.Options options = new WidgetGuildCreate.Options(WidgetGuildTemplates.access$getArgs$p(this.this$0).getLocation(), guildTemplate.getTemplateType(), guildTemplate.getTemplateType() == StockGuildTemplate.CREATE, this.this$0.getString(R.string.guild_create_title), WidgetGuildTemplates.access$getArgs$p(this.this$0).getCloseWithResult());
        if (WidgetGuildTemplates.access$getArgs$p(this.this$0).getGuildTemplate().getSkipCreationIntent()) {
            AnalyticsTracker.openModal$default("Create Guild Step 2", options.getAnalyticsLocation(), null, 4, null);
            WidgetGuildCreate.INSTANCE.showFragment(this.this$0, options);
        } else {
            WidgetGuildTemplates.access$trackPostRegistrationTransition(this.this$0, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE, GuildTemplateAnalytics.STEP_CREATION_INTENT);
            WidgetCreationIntent.Companion companion = WidgetCreationIntent.INSTANCE;
            WidgetGuildTemplates widgetGuildTemplates = this.this$0;
            companion.show(widgetGuildTemplates, WidgetGuildTemplates.access$getArgs$p(widgetGuildTemplates).getTrigger(), options);
        }
    }
}
