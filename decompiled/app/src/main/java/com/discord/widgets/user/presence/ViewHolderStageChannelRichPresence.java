package com.discord.widgets.user.presence;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.ActivityUtils2;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ViewHolderStageChannelRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010#\u001a\u00020\u001a\u0012\u0006\u0010$\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020\u001a\u0012\u0006\u0010&\u001a\u00020\u001a\u0012\u0006\u0010'\u001a\u00020\u001f\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b*\u0010+J1\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJQ\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0015¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u0019\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0015¢\u0006\u0004\b\u0019\u0010\u0018R\u0019\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006,"}, d2 = {"Lcom/discord/widgets/user/presence/ViewHolderStageChannelRichPresence;", "Lcom/discord/widgets/user/presence/ViewHolderUserRichPresence;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/api/activity/Activity;", "model", "", "isMe", "userInSameVoiceChannel", "", "configureButtonUi", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/api/activity/Activity;ZZ)V", "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "Lcom/discord/models/user/User;", "user", "Landroid/content/Context;", "Lcom/discord/app/ApplicationContext;", "applicationContext", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "richPresence", "configureUi", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/utilities/streams/StreamContext;ZLcom/discord/models/user/User;Landroid/content/Context;Lcom/discord/widgets/user/presence/ModelRichPresence;Z)V", "configureTextUi", "(Lcom/discord/api/activity/Activity;Lcom/discord/utilities/streams/StreamContext;)V", "configureAssetUi", "Landroid/widget/TextView;", "richPresenceImageLargeText", "Landroid/widget/TextView;", "getRichPresenceImageLargeText", "()Landroid/widget/TextView;", "Landroid/view/View;", "root", "Lcom/facebook/drawee/view/SimpleDraweeView;", "richPresenceImageLarge", "richPresenceHeader", "richPresenceTitle", "richPresenceDetails", "richPresenceTime", "richPresenceTextContainer", "Landroid/widget/Button;", "richPresencePrimaryButton", "<init>", "(Landroid/view/View;Lcom/facebook/drawee/view/SimpleDraweeView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/Button;Landroid/widget/TextView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ViewHolderStageChannelRichPresence extends ViewHolderUserRichPresence {
    private final TextView richPresenceImageLargeText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderStageChannelRichPresence(View view, SimpleDraweeView simpleDraweeView, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2, Button button, TextView textView5) {
        super(view, simpleDraweeView, null, textView, textView2, textView3, textView4, null, view2, button, null, 5);
        Intrinsics3.checkNotNullParameter(view, "root");
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        Intrinsics3.checkNotNullParameter(textView, "richPresenceHeader");
        Intrinsics3.checkNotNullParameter(textView2, "richPresenceTitle");
        Intrinsics3.checkNotNullParameter(textView3, "richPresenceDetails");
        Intrinsics3.checkNotNullParameter(textView4, "richPresenceTime");
        Intrinsics3.checkNotNullParameter(view2, "richPresenceTextContainer");
        Intrinsics3.checkNotNullParameter(button, "richPresencePrimaryButton");
        Intrinsics3.checkNotNullParameter(textView5, "richPresenceImageLargeText");
        this.richPresenceImageLargeText = textView5;
    }

    private final void configureButtonUi(FragmentManager fragmentManager, Activity model, boolean isMe, boolean userInSameVoiceChannel) {
        ActivityUtils2 stageChannelRichPresencePartyData = model != null ? ActivityUtils.getStageChannelRichPresencePartyData(model) : null;
        if (stageChannelRichPresencePartyData == null) {
            Button richPresencePrimaryButton = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton != null) {
                ViewKt.setVisible(richPresencePrimaryButton, false);
                return;
            }
            return;
        }
        Button richPresencePrimaryButton2 = getRichPresencePrimaryButton();
        if (richPresencePrimaryButton2 != null) {
            richPresencePrimaryButton2.setVisibility(!isMe && !userInSameVoiceChannel ? 0 : 8);
            richPresencePrimaryButton2.setOnClickListener(new ViewHolderStageChannelRichPresence2(richPresencePrimaryButton2, isMe, userInSameVoiceChannel, fragmentManager, stageChannelRichPresencePartyData));
        }
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    public void configureAssetUi(Activity model, StreamContext streamContext) {
        if (model == null) {
            throw new IllegalArgumentException("model must not be null");
        }
        getRichPresenceImageLarge().setVisibility(8);
        ActivityUtils2 stageChannelRichPresencePartyData = ActivityUtils.getStageChannelRichPresencePartyData(model);
        ActivityAssets assets = model.getAssets();
        String smallText = assets != null ? assets.getSmallText() : null;
        ActivityAssets assets2 = model.getAssets();
        String smallImage = assets2 != null ? assets2.getSmallImage() : null;
        if (stageChannelRichPresencePartyData == null || smallText == null) {
            getRoot().setVisibility(8);
            return;
        }
        Guild guild = new Guild(null, null, null, smallText, null, 0, stageChannelRichPresencePartyData.getGuildId(), null, 0L, smallImage, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, false, null, -585, 3, null);
        Resources resources = getRichPresenceImageLarge().getResources();
        boolean zHasIcon = guild.hasIcon();
        getRichPresenceImageLarge().setVisibility(zHasIcon ? 0 : 8);
        this.richPresenceImageLargeText.setVisibility(zHasIcon ^ true ? 0 : 8);
        if (zHasIcon) {
            SimpleDraweeViewExtensions.setGuildIcon$default(getRichPresenceImageLarge(), true, guild, resources.getDimensionPixelSize(R.dimen.guild_icon_radius), Integer.valueOf(IconUtils.getMediaProxySize(resources.getDimensionPixelSize(R.dimen.avatar_size_large))), null, null, null, false, null, 496, null);
        } else {
            this.richPresenceImageLargeText.setText(guild.getShortName());
        }
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    public void configureTextUi(Activity model, StreamContext streamContext) {
        String smallText;
        if (model == null) {
            throw new IllegalArgumentException("model must not be null");
        }
        getRichPresenceTitle().setText(model.getName());
        TextView richPresenceTime = getRichPresenceTime();
        ActivityTimestamps timestamps = model.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
        TextView richPresenceDetails = getRichPresenceDetails();
        if (richPresenceDetails != null) {
            ActivityAssets assets = model.getAssets();
            richPresenceDetails.setVisibility((assets != null ? assets.getSmallText() : null) != null ? 0 : 8);
            ActivityAssets assets2 = model.getAssets();
            if (assets2 == null || (smallText = assets2.getSmallText()) == null) {
                return;
            }
            FormatUtils.n(richPresenceDetails, R.string.stage_discovery_origin_text, new Object[]{smallText}, null, 4);
        }
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        Presence presence;
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        disposeTimer();
        Activity stageChannelActivity = (richPresence == null || (presence = richPresence.getPresence()) == null) ? null : PresenceUtils.INSTANCE.getStageChannelActivity(presence);
        if (stageChannelActivity == null) {
            getRoot().setVisibility(8);
            return;
        }
        getRoot().setVisibility(0);
        configureTextUi(stageChannelActivity, streamContext);
        configureAssetUi(stageChannelActivity, streamContext);
        configureButtonUi(fragmentManager, stageChannelActivity, isMe, userInSameVoiceChannel);
    }

    public final TextView getRichPresenceImageLargeText() {
        return this.richPresenceImageLargeText;
    }
}
