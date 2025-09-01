package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.api.application.Application;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;

/* compiled from: ViewHolderGameRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u001c\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010 \u001a\u00020\u001c\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010\"\u001a\u00020\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020#¢\u0006\u0004\b&\u0010'JQ\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Lcom/discord/widgets/user/presence/ViewHolderGameRichPresence;", "Lcom/discord/widgets/user/presence/ViewHolderUserRichPresence;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "", "isMe", "Lcom/discord/models/user/User;", "user", "Landroid/content/Context;", "Lcom/discord/app/ApplicationContext;", "applicationContext", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "richPresence", "userInSameVoiceChannel", "", "configureUi", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/utilities/streams/StreamContext;ZLcom/discord/models/user/User;Landroid/content/Context;Lcom/discord/widgets/user/presence/ModelRichPresence;Z)V", "Lcom/discord/api/activity/Activity;", "model", "configureTextUi", "(Lcom/discord/api/activity/Activity;Lcom/discord/utilities/streams/StreamContext;)V", "Landroid/view/View;", "root", "Lcom/facebook/drawee/view/SimpleDraweeView;", "richPresenceImageLarge", "richPresenceImageSmall", "Landroid/widget/TextView;", "richPresenceHeader", "richPresenceTitle", "richPresenceDetails", "richPresenceTime", "richPresenceState", "richPresenceTextContainer", "Landroid/widget/Button;", "richPresencePrimaryButton", "richPresenceSecondaryButton", "<init>", "(Landroid/view/View;Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/facebook/drawee/view/SimpleDraweeView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/Button;Landroid/widget/Button;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ViewHolderGameRichPresence extends ViewHolderUserRichPresence {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderGameRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, Button button, Button button2) {
        super(view, simpleDraweeView, simpleDraweeView2, textView, textView2, textView3, textView4, textView5, view2, button, button2, 1);
        Intrinsics3.checkNotNullParameter(view, "root");
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        Intrinsics3.checkNotNullParameter(simpleDraweeView2, "richPresenceImageSmall");
        Intrinsics3.checkNotNullParameter(textView, "richPresenceHeader");
        Intrinsics3.checkNotNullParameter(textView2, "richPresenceTitle");
        Intrinsics3.checkNotNullParameter(textView3, "richPresenceDetails");
        Intrinsics3.checkNotNullParameter(textView4, "richPresenceTime");
        Intrinsics3.checkNotNullParameter(textView5, "richPresenceState");
        Intrinsics3.checkNotNullParameter(view2, "richPresenceTextContainer");
        Intrinsics3.checkNotNullParameter(button, "richPresencePrimaryButton");
        Intrinsics3.checkNotNullParameter(button2, "richPresenceSecondaryButton");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004b  */
    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void configureTextUi(Activity model, StreamContext streamContext) {
        String string;
        Context context;
        if (model == null) {
            throw new IllegalArgumentException("model must not be null");
        }
        String state = model.getState();
        if (state != null) {
            ActivityParty party = model.getParty();
            if (party != null) {
                PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
                CharSequence charSequenceH = (presenceUtils.getMaxSize(party) == 0 || (context = getRoot().getContext()) == null) ? null : FormatUtils.h(context, R.string.user_activity_state_size, new Object[]{String.valueOf(presenceUtils.getCurrentSize(party)), String.valueOf(presenceUtils.getMaxSize(party))}, null, 4);
                if (charSequenceH == null) {
                    charSequenceH = "";
                }
                String str = state + ' ' + charSequenceH;
                Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
                string = Strings4.trim(str).toString();
            }
        } else {
            string = null;
        }
        TextView richPresenceHeader = getRichPresenceHeader();
        Context context2 = getRichPresenceHeader().getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "richPresenceHeader.context");
        richPresenceHeader.setText(PresenceUtils.getActivityHeader(context2, model));
        getRichPresenceTitle().setText(model.getName());
        TextView richPresenceDetails = getRichPresenceDetails();
        if (richPresenceDetails != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceDetails, model.getDetails());
        }
        TextView richPresenceState = getRichPresenceState();
        if (richPresenceState != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceState, string);
        }
        TextView richPresenceTime = getRichPresenceTime();
        ActivityTimestamps timestamps = model.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        String applicationIcon$default;
        Application primaryApplication;
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        super.configureUi(fragmentManager, streamContext, isMe, user, applicationContext, richPresence, userInSameVoiceChannel);
        if (getRichPresenceImageLarge().getVisibility() != 0) {
            if (richPresence == null || (primaryApplication = richPresence.getPrimaryApplication()) == null) {
                applicationIcon$default = null;
            } else {
                long id2 = primaryApplication.getId();
                String icon = primaryApplication.getIcon();
                if (icon == null) {
                    icon = "";
                }
                applicationIcon$default = IconUtils.getApplicationIcon$default(id2, icon, 0, 4, (Object) null);
            }
            getRichPresenceImageLarge().setVisibility(0);
            MGImages.setImage$default(getRichPresenceImageLarge(), applicationIcon$default, 0, 0, false, null, null, 124, null);
        }
    }
}
