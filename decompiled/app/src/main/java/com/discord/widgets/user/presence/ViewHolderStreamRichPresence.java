package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.StreamPreviewView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ViewHolderStreamRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020)\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010-\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010/\u001a\u00020+\u0012\u0006\u00100\u001a\u00020+\u0012\u0006\u00101\u001a\u00020'\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b2\u00103J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJQ\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u001f\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u001f\u0010\u001eJ\u001b\u0010\"\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040 ¢\u0006\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u00064"}, d2 = {"Lcom/discord/widgets/user/presence/ViewHolderStreamRichPresence;", "Lcom/discord/widgets/user/presence/ViewHolderUserRichPresence;", "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "", "configureStreamPreview", "(Lcom/discord/utilities/streams/StreamContext;)V", "", "state", "Lcom/discord/api/activity/ActivityParty;", "party", "getRichPresenceStateText", "(Ljava/lang/String;Lcom/discord/api/activity/ActivityParty;)Ljava/lang/String;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "isMe", "Lcom/discord/models/user/User;", "user", "Landroid/content/Context;", "Lcom/discord/app/ApplicationContext;", "applicationContext", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "richPresence", "userInSameVoiceChannel", "configureUi", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/utilities/streams/StreamContext;ZLcom/discord/models/user/User;Landroid/content/Context;Lcom/discord/widgets/user/presence/ModelRichPresence;Z)V", "Lcom/discord/api/activity/Activity;", "model", "configureTextUi", "(Lcom/discord/api/activity/Activity;Lcom/discord/utilities/streams/StreamContext;)V", "configureAssetUi", "Lkotlin/Function0;", "onStreamPreviewClicked", "setOnStreamPreviewClicked", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/discord/views/StreamPreviewView;", "streamPreview", "Lcom/discord/views/StreamPreviewView;", "Landroid/view/View;", "root", "Lcom/facebook/drawee/view/SimpleDraweeView;", "richPresenceImageLarge", "Landroid/widget/TextView;", "richPresenceHeader", "richPresenceTitle", "richPresenceDetails", "richPresenceTime", "richPresenceState", "richPresenceTextContainer", "<init>", "(Landroid/view/View;Lcom/facebook/drawee/view/SimpleDraweeView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Lcom/discord/views/StreamPreviewView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ViewHolderStreamRichPresence extends ViewHolderUserRichPresence {
    private final StreamPreviewView streamPreview;

    /* compiled from: ViewHolderStreamRichPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.presence.ViewHolderStreamRichPresence$setOnStreamPreviewClicked$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onStreamPreviewClicked;

        public AnonymousClass1(Function0 function0) {
            this.$onStreamPreviewClicked = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onStreamPreviewClicked.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderStreamRichPresence(View view, SimpleDraweeView simpleDraweeView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, StreamPreviewView streamPreviewView) {
        super(view, simpleDraweeView, null, textView, textView2, textView3, textView4, textView5, view2, null, null, 4);
        Intrinsics3.checkNotNullParameter(view, "root");
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        Intrinsics3.checkNotNullParameter(textView, "richPresenceHeader");
        Intrinsics3.checkNotNullParameter(textView2, "richPresenceTitle");
        Intrinsics3.checkNotNullParameter(textView3, "richPresenceDetails");
        Intrinsics3.checkNotNullParameter(textView4, "richPresenceTime");
        Intrinsics3.checkNotNullParameter(textView5, "richPresenceState");
        Intrinsics3.checkNotNullParameter(view2, "richPresenceTextContainer");
        Intrinsics3.checkNotNullParameter(streamPreviewView, "streamPreview");
        this.streamPreview = streamPreviewView;
    }

    private final void configureStreamPreview(StreamContext streamContext) {
        StoreApplicationStreamPreviews.StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
        if (preview == null) {
            this.streamPreview.setVisibility(8);
        } else {
            this.streamPreview.a(preview, streamContext.getJoinability(), streamContext.isCurrentUserParticipating());
            this.streamPreview.setVisibility(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getRichPresenceStateText(String state, ActivityParty party) {
        CharSequence charSequenceJ;
        if (state == null) {
            return null;
        }
        if (party != null) {
            PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
            charSequenceJ = presenceUtils.getMaxSize(party) != 0 ? FormatUtils.j(getRoot(), R.string.user_activity_state_size, new Object[]{String.valueOf(presenceUtils.getCurrentSize(party)), String.valueOf(presenceUtils.getMaxSize(party))}, null, 4) : null;
            if (charSequenceJ == null) {
                charSequenceJ = "";
            }
        }
        String str = state + ' ' + charSequenceJ;
        Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
        return Strings4.trim(str).toString();
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void configureAssetUi(Activity model, StreamContext streamContext) {
        super.configureAssetUi(model, streamContext);
        getRichPresenceImageLarge().setVisibility(8);
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void configureTextUi(Activity model, StreamContext streamContext) {
        if (streamContext == null) {
            throw new IllegalArgumentException("streamContext must not be null");
        }
        Guild guild = streamContext.getGuild();
        String name = guild != null ? guild.getName() : null;
        getRichPresenceHeader().setText(name != null ? FormatUtils.j(getRichPresenceHeader(), R.string.user_activity_header_streaming_to_guild, new Object[]{name}, null, 4) : FormatUtils.j(getRichPresenceHeader(), R.string.user_activity_header_streaming_to_dm, new Object[0], null, 4));
        if (model == null || !ActivityUtils.isGameActivity(model)) {
            getRichPresenceTextContainer().setVisibility(8);
            return;
        }
        String richPresenceStateText = getRichPresenceStateText(model.getState(), model.getParty());
        getRichPresenceTextContainer().setVisibility(0);
        getRichPresenceTitle().setText(model.getName());
        TextView richPresenceDetails = getRichPresenceDetails();
        if (richPresenceDetails != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceDetails, model.getDetails());
        }
        TextView richPresenceState = getRichPresenceState();
        if (richPresenceState != null) {
            ViewExtensions.setTextAndVisibilityBy(richPresenceState, richPresenceStateText);
        }
        TextView richPresenceTime = getRichPresenceTime();
        ActivityTimestamps timestamps = model.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        Presence presence;
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        disposeTimer();
        Activity playingActivity = (richPresence == null || (presence = richPresence.getPresence()) == null) ? null : PresenceUtils.INSTANCE.getPlayingActivity(presence);
        boolean z2 = (streamContext != null ? streamContext.getJoinability() : null) == StreamContext.Joinability.MISSING_PERMISSIONS;
        if ((streamContext == null && playingActivity == null) || z2) {
            getRoot().setVisibility(8);
            return;
        }
        getRoot().setVisibility(0);
        configureTextUi(playingActivity, streamContext);
        configureAssetUi(playingActivity, streamContext);
        configureStreamPreview(streamContext);
    }

    public final void setOnStreamPreviewClicked(Function0<Unit> onStreamPreviewClicked) {
        Intrinsics3.checkNotNullParameter(onStreamPreviewClicked, "onStreamPreviewClicked");
        this.streamPreview.setOnClickListener(new AnonymousClass1(onStreamPreviewClicked));
    }
}
