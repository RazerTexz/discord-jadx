package com.discord.widgets.guildscheduledevent.buttonconfiguration;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;

/* compiled from: ButtonConfiguration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u0006R\u0016\u0010\f\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0013\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00078&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0016R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0016R\u0016\u0010 \u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\rR\u0016\u0010\"\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\rR\u0016\u0010$\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\r¨\u0006%"}, d2 = {"Lcom/discord/widgets/guildscheduledevent/buttonconfiguration/ButtonConfiguration;", "", "Landroid/content/Context;", "context", "", "primaryButtonText", "(Landroid/content/Context;)Ljava/lang/CharSequence;", "", "secondaryButtonTextColor", "(Landroid/content/Context;)I", "secondaryButtonText", "", "isShareVisible", "()Z", "getSecondaryButtonEnabled", "secondaryButtonEnabled", "isAnyButtonVisible", "getSecondaryButtonBackground", "()I", "secondaryButtonBackground", "Landroid/view/View$OnClickListener;", "getShareButtonOnClickListener", "()Landroid/view/View$OnClickListener;", "shareButtonOnClickListener", "getSecondaryButtonTextDrawableRes", "secondaryButtonTextDrawableRes", "getExtrasButtonOnClickListener", "extrasButtonOnClickListener", "getSecondaryButtonOnClickListener", "secondaryButtonOnClickListener", "getPrimaryButtonOnClickListener", "primaryButtonOnClickListener", "isExtrasVisible", "getPrimaryButtonVisible", "primaryButtonVisible", "getSecondaryButtonVisible", "secondaryButtonVisible", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public interface ButtonConfiguration {
    View.OnClickListener getExtrasButtonOnClickListener();

    View.OnClickListener getPrimaryButtonOnClickListener();

    boolean getPrimaryButtonVisible();

    int getSecondaryButtonBackground();

    boolean getSecondaryButtonEnabled();

    View.OnClickListener getSecondaryButtonOnClickListener();

    int getSecondaryButtonTextDrawableRes();

    boolean getSecondaryButtonVisible();

    View.OnClickListener getShareButtonOnClickListener();

    boolean isAnyButtonVisible();

    boolean isExtrasVisible();

    boolean isShareVisible();

    CharSequence primaryButtonText(Context context);

    CharSequence secondaryButtonText(Context context);

    int secondaryButtonTextColor(Context context);
}
