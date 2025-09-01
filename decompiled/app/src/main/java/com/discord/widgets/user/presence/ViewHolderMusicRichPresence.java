package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityPlatform;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.models.user.User;
import com.discord.utilities.integrations.SpotifyHelper;
import com.discord.utilities.presence.ActivityUtils;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;

/* compiled from: ViewHolderMusicRichPresence.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010)\u001a\u00020'\u0012\u0006\u0010*\u001a\u00020\u001e\u0012\u0006\u0010+\u001a\u00020\u001e\u0012\u0006\u0010,\u001a\u00020\u001e\u0012\u0006\u0010-\u001a\u00020\u001e\u0012\u0006\u0010.\u001a\u00020%\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010$\u001a\u00020\u001e\u0012\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b1\u00102JQ\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\f\u001a\u00060\nj\u0002`\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0019\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010 ¨\u00063"}, d2 = {"Lcom/discord/widgets/user/presence/ViewHolderMusicRichPresence;", "Lcom/discord/widgets/user/presence/ViewHolderUserRichPresence;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lcom/discord/utilities/streams/StreamContext;", "streamContext", "", "isMe", "Lcom/discord/models/user/User;", "user", "Landroid/content/Context;", "Lcom/discord/app/ApplicationContext;", "applicationContext", "Lcom/discord/widgets/user/presence/ModelRichPresence;", "richPresence", "userInSameVoiceChannel", "", "configureUi", "(Landroidx/fragment/app/FragmentManager;Lcom/discord/utilities/streams/StreamContext;ZLcom/discord/models/user/User;Landroid/content/Context;Lcom/discord/widgets/user/presence/ModelRichPresence;Z)V", "Lcom/discord/api/activity/Activity;", "model", "configureAssetUi", "(Lcom/discord/api/activity/Activity;Lcom/discord/utilities/streams/StreamContext;)V", "Lcom/discord/api/activity/ActivityTimestamps;", "timestamps", "setTimeTextViews", "(Lcom/discord/api/activity/ActivityTimestamps;)V", "Landroid/widget/SeekBar;", "richPresenceSeekbar", "Landroid/widget/SeekBar;", "Landroid/widget/TextView;", "richPresenceMusicElapsed", "Landroid/widget/TextView;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "richPresenceMusicDuration", "Landroid/view/View;", "root", "Lcom/facebook/drawee/view/SimpleDraweeView;", "richPresenceImageLarge", "richPresenceImageSmall", "richPresenceHeader", "richPresenceTitle", "richPresenceDetails", "richPresenceTime", "richPresenceTextContainer", "Landroid/widget/Button;", "richPresencePrimaryButton", "<init>", "(Landroid/view/View;Lcom/facebook/drawee/view/SimpleDraweeView;Lcom/facebook/drawee/view/SimpleDraweeView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/widget/TextView;Landroid/view/View;Landroid/widget/Button;Landroid/widget/SeekBar;Landroid/widget/TextView;Landroid/widget/TextView;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class ViewHolderMusicRichPresence extends ViewHolderUserRichPresence {
    private final Clock clock;
    private final TextView richPresenceMusicDuration;
    private final TextView richPresenceMusicElapsed;
    private final SeekBar richPresenceSeekbar;

    /* compiled from: ViewHolderMusicRichPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.presence.ViewHolderMusicRichPresence$configureUi$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Activity $activity;

        public AnonymousClass1(Activity activity) {
            this.$activity = activity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SpotifyHelper.INSTANCE.launchTrack(outline.x(view, "it", "it.context"), this.$activity);
        }
    }

    /* compiled from: ViewHolderMusicRichPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.presence.ViewHolderMusicRichPresence$configureUi$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Activity $activity;

        public AnonymousClass2(Activity activity) {
            this.$activity = activity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SpotifyHelper.INSTANCE.launchTrack(outline.x(view, "it", "it.context"), this.$activity);
        }
    }

    /* compiled from: ViewHolderMusicRichPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.presence.ViewHolderMusicRichPresence$configureUi$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Activity $activity;
        public final /* synthetic */ boolean $isMe;
        public final /* synthetic */ User $user;

        public AnonymousClass3(Activity activity, User user, boolean z2) {
            this.$activity = activity;
            this.$user = user;
            this.$isMe = z2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SpotifyHelper spotifyHelper = SpotifyHelper.INSTANCE;
            Context contextX = outline.x(view, "it", "it.context");
            Activity activity = this.$activity;
            User user = this.$user;
            spotifyHelper.launchAlbum(contextX, activity, user != null ? user.getId() : 0L, this.$isMe);
        }
    }

    /* compiled from: ViewHolderMusicRichPresence.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.user.presence.ViewHolderMusicRichPresence$configureUi$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            SpotifyHelper spotifyHelper = SpotifyHelper.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            spotifyHelper.openPlayStoreForSpotify(context);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewHolderMusicRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view2, Button button, SeekBar seekBar, TextView textView5, TextView textView6) {
        super(view, simpleDraweeView, simpleDraweeView2, textView, textView2, textView3, textView4, null, view2, button, null, 2);
        Intrinsics3.checkNotNullParameter(view, "root");
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        Intrinsics3.checkNotNullParameter(simpleDraweeView2, "richPresenceImageSmall");
        Intrinsics3.checkNotNullParameter(textView, "richPresenceHeader");
        Intrinsics3.checkNotNullParameter(textView2, "richPresenceTitle");
        Intrinsics3.checkNotNullParameter(textView3, "richPresenceDetails");
        Intrinsics3.checkNotNullParameter(textView4, "richPresenceTime");
        Intrinsics3.checkNotNullParameter(view2, "richPresenceTextContainer");
        Intrinsics3.checkNotNullParameter(button, "richPresencePrimaryButton");
        Intrinsics3.checkNotNullParameter(seekBar, "richPresenceSeekbar");
        Intrinsics3.checkNotNullParameter(textView5, "richPresenceMusicDuration");
        Intrinsics3.checkNotNullParameter(textView6, "richPresenceMusicElapsed");
        this.richPresenceSeekbar = seekBar;
        this.richPresenceMusicDuration = textView5;
        this.richPresenceMusicElapsed = textView6;
        this.clock = ClockFactory.get();
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void configureAssetUi(Activity model, StreamContext streamContext) {
        super.configureAssetUi(model, streamContext);
        SimpleDraweeView richPresenceImageSmall = getRichPresenceImageSmall();
        if (richPresenceImageSmall != null) {
            ViewKt.setVisible(richPresenceImageSmall, true);
        }
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    @MainThread
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(applicationContext, "applicationContext");
        disposeTimer();
        Context context = getRoot().getContext();
        Activity primaryActivity = richPresence != null ? richPresence.getPrimaryActivity() : null;
        if (primaryActivity == null || !ActivityUtils.isRichPresence(primaryActivity)) {
            getRoot().setVisibility(8);
            return;
        }
        getRoot().setVisibility(0);
        boolean zEquals = StringsJVM.equals(primaryActivity.getName(), ActivityPlatform.SPOTIFY.name(), true);
        String state = primaryActivity.getState();
        String strReplace$default = state != null ? StringsJVM.replace$default(state, ';', ',', false, 4, (Object) null) : null;
        TextView richPresenceHeader = getRichPresenceHeader();
        Context context2 = getRichPresenceHeader().getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "richPresenceHeader.context");
        richPresenceHeader.setText(PresenceUtils.getActivityHeader(context2, primaryActivity));
        getRichPresenceTitle().setText(primaryActivity.getDetails());
        TextView richPresenceDetails = getRichPresenceDetails();
        if (richPresenceDetails != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            ViewExtensions.setTextAndVisibilityBy(richPresenceDetails, FormatUtils.h(context, R.string.user_activity_listening_artists, new Object[]{strReplace$default}, null, 4));
        }
        TextView richPresenceTime = getRichPresenceTime();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        Object[] objArr = new Object[1];
        ActivityAssets assets = primaryActivity.getAssets();
        objArr[0] = assets != null ? assets.getLargeText() : null;
        ViewExtensions.setTextAndVisibilityBy(richPresenceTime, FormatUtils.h(context, R.string.user_activity_listening_album, objArr, null, 4));
        getRichPresenceTextContainer().setSelected(true);
        configureAssetUi(primaryActivity, streamContext);
        Button richPresencePrimaryButton = getRichPresencePrimaryButton();
        if (richPresencePrimaryButton != null) {
            ViewKt.setVisible(richPresencePrimaryButton, zEquals);
        }
        this.richPresenceSeekbar.setVisibility(zEquals ? 0 : 8);
        this.richPresenceMusicDuration.setVisibility(zEquals ? 0 : 8);
        this.richPresenceMusicElapsed.setVisibility(zEquals ? 0 : 8);
        if (isMe) {
            Button richPresencePrimaryButton2 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton2 != null) {
                FormatUtils.n(richPresencePrimaryButton2, R.string.user_activity_cannot_play_self, new Object[0], null, 4);
            }
            Button richPresencePrimaryButton3 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton3 != null) {
                richPresencePrimaryButton3.setEnabled(false);
            }
        } else {
            Button richPresencePrimaryButton4 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton4 != null) {
                FormatUtils.n(richPresencePrimaryButton4, R.string.user_activity_play_on_platform, new Object[]{primaryActivity.getName()}, null, 4);
            }
            Button richPresencePrimaryButton5 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton5 != null) {
                richPresencePrimaryButton5.setEnabled(true);
            }
        }
        if (!SpotifyHelper.INSTANCE.isSpotifyInstalled(context)) {
            Button richPresencePrimaryButton6 = getRichPresencePrimaryButton();
            if (richPresencePrimaryButton6 != null) {
                richPresencePrimaryButton6.setOnClickListener(AnonymousClass4.INSTANCE);
                return;
            }
            return;
        }
        getRichPresenceTitle().setOnClickListener(new AnonymousClass1(primaryActivity));
        Button richPresencePrimaryButton7 = getRichPresencePrimaryButton();
        if (richPresencePrimaryButton7 != null) {
            richPresencePrimaryButton7.setOnClickListener(new AnonymousClass2(primaryActivity));
        }
        getRichPresenceImageLarge().setOnClickListener(new AnonymousClass3(primaryActivity, user, isMe));
    }

    @Override // com.discord.widgets.user.presence.ViewHolderUserRichPresence
    public void setTimeTextViews(ActivityTimestamps timestamps) {
        if (timestamps != null) {
            long jCurrentTimeMillis = this.clock.currentTimeMillis();
            long jB = timestamps.b() - timestamps.c();
            long jC = jCurrentTimeMillis >= timestamps.b() ? jB : jCurrentTimeMillis - timestamps.c();
            this.richPresenceSeekbar.setProgress((int) ((jC / jB) * 100.0f));
            TextView textView = this.richPresenceMusicElapsed;
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            textView.setText(TimeUtils.toFriendlyStringSimple$default(timeUtils, jC, null, null, 4, null));
            this.richPresenceMusicDuration.setText(TimeUtils.toFriendlyStringSimple$default(timeUtils, jB, null, null, 4, null));
        }
    }
}
