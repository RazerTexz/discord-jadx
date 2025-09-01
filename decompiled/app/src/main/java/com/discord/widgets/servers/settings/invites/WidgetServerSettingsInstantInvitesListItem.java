package com.discord.widgets.servers.settings.invites;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.core.view.OneShotPreDrawListener;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.User;
import com.discord.databinding.WidgetServerSettingsInstantInviteListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.CoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites;
import d0.z.d.Intrinsics3;
import java.util.Arrays;
import kotlin.Metadata;

/* compiled from: WidgetServerSettingsInstantInvitesListItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvitesListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Adapter;", "Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$InviteItem;", "Lcom/discord/models/domain/ModelInvite;", "invite", "", "setupExpirationTime", "(Lcom/discord/models/domain/ModelInvite;)V", "", "timeToExpiration", "setCountdownText", "(J)V", "cancelTimer", "()V", "", "getUsesText", "(Lcom/discord/models/domain/ModelInvite;)Ljava/lang/String;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "onConfigure", "(ILcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Model$InviteItem;)V", "Lcom/discord/databinding/WidgetServerSettingsInstantInviteListItemBinding;", "binding", "Lcom/discord/databinding/WidgetServerSettingsInstantInviteListItemBinding;", "currentInviteCode", "Ljava/lang/String;", "Landroid/os/CountDownTimer;", "countdownTimer", "Landroid/os/CountDownTimer;", "adapter", "<init>", "(Lcom/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvites$Adapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesListItem extends MGRecyclerViewHolder<WidgetServerSettingsInstantInvites.Adapter, WidgetServerSettingsInstantInvites.Model.InviteItem> {
    private final WidgetServerSettingsInstantInviteListItemBinding binding;
    private CountDownTimer countdownTimer;
    private String currentInviteCode;

    /* compiled from: WidgetServerSettingsInstantInvitesListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", "onClick", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvitesListItem$onConfigure$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsInstantInvites.Model.InviteItem $data;

        public AnonymousClass1(WidgetServerSettingsInstantInvites.Model.InviteItem inviteItem) {
            this.$data = inviteItem;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsInstantInvitesListItem.access$getAdapter$p(WidgetServerSettingsInstantInvitesListItem.this).onInviteSelected(this.$data.getInvite());
        }
    }

    /* compiled from: WidgetServerSettingsInstantInvitesListItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/discord/widgets/servers/settings/invites/WidgetServerSettingsInstantInvitesListItem$setupExpirationTime$1", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", "onTick", "(J)V", "onFinish", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvitesListItem$setupExpirationTime$1, reason: invalid class name */
    public static final class AnonymousClass1 extends CountDownTimer {
        public final /* synthetic */ ModelInvite $invite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelInvite modelInvite, long j, long j2) {
            super(j, j2);
            this.$invite = modelInvite;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            WidgetServerSettingsInstantInvitesListItem.access$setCountdownText(WidgetServerSettingsInstantInvitesListItem.this, 0L);
            WidgetServerSettingsInstantInvitesListItem.access$getAdapter$p(WidgetServerSettingsInstantInvitesListItem.this).onInviteExpired(this.$invite);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            WidgetServerSettingsInstantInvitesListItem.access$setCountdownText(WidgetServerSettingsInstantInvitesListItem.this, millisUntilFinished);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsInstantInvitesListItem(WidgetServerSettingsInstantInvites.Adapter adapter) {
        super(R.layout.widget_server_settings_instant_invite_list_item, adapter);
        Intrinsics3.checkNotNullParameter(adapter, "adapter");
        View view = this.itemView;
        int i = R.id.invite_barrier_1;
        Barrier barrier = (Barrier) view.findViewById(R.id.invite_barrier_1);
        if (barrier != null) {
            i = R.id.invite_barrier_2;
            Barrier barrier2 = (Barrier) view.findViewById(R.id.invite_barrier_2);
            if (barrier2 != null) {
                i = R.id.invite_channel;
                TextView textView = (TextView) view.findViewById(R.id.invite_channel);
                if (textView != null) {
                    i = R.id.invite_code;
                    TextView textView2 = (TextView) view.findViewById(R.id.invite_code);
                    if (textView2 != null) {
                        i = R.id.invite_container;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.invite_container);
                        if (linearLayout != null) {
                            i = R.id.invite_divider;
                            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.invite_divider);
                            if (frameLayout != null) {
                                i = R.id.invite_expiration_container;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.invite_expiration_container);
                                if (linearLayout2 != null) {
                                    i = R.id.invite_expiration_time;
                                    TextView textView3 = (TextView) view.findViewById(R.id.invite_expiration_time);
                                    if (textView3 != null) {
                                        i = R.id.invite_settings_icon;
                                        ImageView imageView = (ImageView) view.findViewById(R.id.invite_settings_icon);
                                        if (imageView != null) {
                                            i = R.id.invite_uses;
                                            TextView textView4 = (TextView) view.findViewById(R.id.invite_uses);
                                            if (textView4 != null) {
                                                i = R.id.invite_uses_container;
                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.invite_uses_container);
                                                if (linearLayout3 != null) {
                                                    i = R.id.settings_member;
                                                    SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R.id.settings_member);
                                                    if (settingsMemberView != null) {
                                                        WidgetServerSettingsInstantInviteListItemBinding widgetServerSettingsInstantInviteListItemBinding = new WidgetServerSettingsInstantInviteListItemBinding((CardView) view, barrier, barrier2, textView, textView2, linearLayout, frameLayout, linearLayout2, textView3, imageView, textView4, linearLayout3, settingsMemberView);
                                                        Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsInstantInviteListItemBinding, "WidgetServerSettingsInst…temBinding.bind(itemView)");
                                                        this.binding = widgetServerSettingsInstantInviteListItemBinding;
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetServerSettingsInstantInvites.Adapter access$getAdapter$p(WidgetServerSettingsInstantInvitesListItem widgetServerSettingsInstantInvitesListItem) {
        return (WidgetServerSettingsInstantInvites.Adapter) widgetServerSettingsInstantInvitesListItem.adapter;
    }

    public static final /* synthetic */ void access$setCountdownText(WidgetServerSettingsInstantInvitesListItem widgetServerSettingsInstantInvitesListItem, long j) {
        widgetServerSettingsInstantInvitesListItem.setCountdownText(j);
    }

    private final void cancelTimer() {
        CountDownTimer countDownTimer = this.countdownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countdownTimer = null;
        this.currentInviteCode = null;
    }

    private final String getUsesText(ModelInvite invite) {
        int uses = invite.getUses();
        int maxUses = invite.getMaxUses();
        String strValueOf = String.valueOf(uses);
        if (maxUses <= 0) {
            return strValueOf;
        }
        return strValueOf + " / " + maxUses;
    }

    @SuppressLint({"SetTextI18n"})
    private final void setCountdownText(long timeToExpiration) {
        long j = 60;
        int i = (int) ((timeToExpiration / 1000) % j);
        int i2 = (int) ((timeToExpiration / 60000) % j);
        long j2 = 24;
        int i3 = (int) ((timeToExpiration / 3600000) % j2);
        int i4 = (int) ((timeToExpiration / 86400000) % j2);
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteExpirationTime");
        String str = String.format("%02d:%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i)}, 4));
        Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
        textView.setText(str);
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteExpirationTime");
        textView2.setTextColor(ColorCompat.getColor(textView2, R.color.status_green_500_dark));
    }

    private final void setupExpirationTime(ModelInvite invite) {
        if (invite.getMaxAge() == 0) {
            this.binding.d.setText(R.string.max_age_never);
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteExpirationTime");
            textView.setTextColor(ColorCompat.getColor(textView, R.color.grey_1));
            cancelTimer();
            return;
        }
        if (invite.getTimeToExpirationMillis() <= 0) {
            setCountdownText(0L);
            cancelTimer();
            return;
        }
        if ((!Intrinsics3.areEqual(invite.code, this.currentInviteCode)) || this.currentInviteCode == null) {
            setCountdownText(invite.getTimeToExpirationMillis());
            cancelTimer();
            this.currentInviteCode = invite.code;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(invite, invite.getTimeToExpirationMillis(), 1000L);
            this.countdownTimer = anonymousClass1;
            if (anonymousClass1 != null) {
                anonymousClass1.start();
            }
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetServerSettingsInstantInvites.Model.InviteItem inviteItem) {
        onConfigure2(i, inviteItem);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetServerSettingsInstantInvites.Model.InviteItem data) {
        String strD;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, (int) data);
        User inviter = data.getInvite().getInviter();
        this.binding.a.setOnClickListener(new AnonymousClass1(data));
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteCode");
        textView.setText(data.getInvite().code);
        TextView textView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.inviteUses");
        textView2.setText(getUsesText(data.getInvite()));
        TextView textView3 = this.binding.f2574b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.inviteChannel");
        Channel channel = data.getInvite().getChannel();
        if (channel != null) {
            TextView textView4 = this.binding.f2574b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.inviteChannel");
            Context context = textView4.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.inviteChannel.context");
            strD = ChannelUtils.d(channel, context, true);
        } else {
            strD = null;
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, strD);
        SettingsMemberView settingsMemberView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(settingsMemberView, "binding.settingsMember");
        settingsMemberView.setVisibility(inviter != null ? 0 : 8);
        if (inviter != null) {
            this.binding.f.a(new CoreUser(inviter), data.getGuildMember());
            SettingsMemberView settingsMemberView2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView2, "binding.settingsMember");
            settingsMemberView2.setVisibility(0);
        } else {
            SettingsMemberView settingsMemberView3 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(settingsMemberView3, "binding.settingsMember");
            settingsMemberView3.setVisibility(8);
        }
        setupExpirationTime(data.getInvite());
        TextView textView5 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.inviteExpirationTime");
        Intrinsics3.checkNotNullExpressionValue(OneShotPreDrawListener.add(textView5, new WidgetServerSettingsInstantInvitesListItem$onConfigure$$inlined$doOnPreDraw$1(textView5)), "View.doOnPreDraw(\n    crossinline action: (view: View) -> Unit\n): OneShotPreDrawListener = OneShotPreDrawListener.add(this) { action(this) }");
    }
}
