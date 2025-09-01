package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.StageRaisedHandsItemUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR.\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R.\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006 "}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lkotlin/Function1;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "", "onViewProfile", "Lkotlin/jvm/functions/Function1;", "getOnViewProfile", "()Lkotlin/jvm/functions/Function1;", "setOnViewProfile", "(Lkotlin/jvm/functions/Function1;)V", "onDismissRequest", "getOnDismissRequest", "setOnDismissRequest", "onInviteToSpeak", "getOnInviteToSpeak", "setOnInviteToSpeak", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Companion", "ListItem", "ViewHolderParticipant", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter extends MGRecyclerAdapterSimple<ListItem> {
    private static final int MILLIS_PER_DAY = 86400000;
    private static final int NEW_USER_DAYS_THRESOLD = 7;
    private static final int VIEW_TYPE_PARTICIPANT = 0;
    private Function1<? super StoreVoiceParticipants.VoiceUser, Unit> onDismissRequest;
    private Function1<? super StoreVoiceParticipants.VoiceUser, Unit> onInviteToSpeak;
    private Function1<? super StoreVoiceParticipants.VoiceUser, Unit> onViewProfile;

    /* compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "<init>", "()V", "Participant", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ListItem implements MGRecyclerDataPayload {

        /* compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b-\u0010.J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ>\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\nR\u001c\u0010!\u001a\u00020\u00148\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0016R\u001c\u0010$\u001a\u00020\u00178\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0019R\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010'\u001a\u0004\b(\u0010\rR\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010\u0007R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010+\u001a\u0004\b,\u0010\u0004¨\u0006/"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component1", "()Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "Lcom/discord/api/utcdatetime/UtcDateTime;", "component2", "()Lcom/discord/api/utcdatetime/UtcDateTime;", "Lcom/discord/models/member/GuildMember;", "component3", "()Lcom/discord/models/member/GuildMember;", "Lcom/discord/api/role/GuildRole;", "component4", "()Lcom/discord/api/role/GuildRole;", "participant", "requestToSpeakTimestamp", "member", "role", "copy", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/utcdatetime/UtcDateTime;Lcom/discord/models/member/GuildMember;Lcom/discord/api/role/GuildRole;)Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/member/GuildMember;", "getMember", "key", "Ljava/lang/String;", "getKey", "type", "I", "getType", "Lcom/discord/api/role/GuildRole;", "getRole", "Lcom/discord/api/utcdatetime/UtcDateTime;", "getRequestToSpeakTimestamp", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "getParticipant", "<init>", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Lcom/discord/api/utcdatetime/UtcDateTime;Lcom/discord/models/member/GuildMember;Lcom/discord/api/role/GuildRole;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Participant extends ListItem {
            private final String key;
            private final GuildMember member;
            private final StoreVoiceParticipants.VoiceUser participant;
            private final UtcDateTime requestToSpeakTimestamp;
            private final GuildRole role;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Participant(StoreVoiceParticipants.VoiceUser voiceUser, UtcDateTime utcDateTime, GuildMember guildMember, GuildRole guildRole) {
                super(null);
                Intrinsics3.checkNotNullParameter(voiceUser, "participant");
                this.participant = voiceUser;
                this.requestToSpeakTimestamp = utcDateTime;
                this.member = guildMember;
                this.role = guildRole;
                this.key = String.valueOf(voiceUser.getUser().getId());
            }

            public static /* synthetic */ Participant copy$default(Participant participant, StoreVoiceParticipants.VoiceUser voiceUser, UtcDateTime utcDateTime, GuildMember guildMember, GuildRole guildRole, int i, Object obj) {
                if ((i & 1) != 0) {
                    voiceUser = participant.participant;
                }
                if ((i & 2) != 0) {
                    utcDateTime = participant.requestToSpeakTimestamp;
                }
                if ((i & 4) != 0) {
                    guildMember = participant.member;
                }
                if ((i & 8) != 0) {
                    guildRole = participant.role;
                }
                return participant.copy(voiceUser, utcDateTime, guildMember, guildRole);
            }

            /* renamed from: component1, reason: from getter */
            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            /* renamed from: component2, reason: from getter */
            public final UtcDateTime getRequestToSpeakTimestamp() {
                return this.requestToSpeakTimestamp;
            }

            /* renamed from: component3, reason: from getter */
            public final GuildMember getMember() {
                return this.member;
            }

            /* renamed from: component4, reason: from getter */
            public final GuildRole getRole() {
                return this.role;
            }

            public final Participant copy(StoreVoiceParticipants.VoiceUser participant, UtcDateTime requestToSpeakTimestamp, GuildMember member, GuildRole role) {
                Intrinsics3.checkNotNullParameter(participant, "participant");
                return new Participant(participant, requestToSpeakTimestamp, member, role);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Participant)) {
                    return false;
                }
                Participant participant = (Participant) other;
                return Intrinsics3.areEqual(this.participant, participant.participant) && Intrinsics3.areEqual(this.requestToSpeakTimestamp, participant.requestToSpeakTimestamp) && Intrinsics3.areEqual(this.member, participant.member) && Intrinsics3.areEqual(this.role, participant.role);
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final GuildMember getMember() {
                return this.member;
            }

            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            public final UtcDateTime getRequestToSpeakTimestamp() {
                return this.requestToSpeakTimestamp;
            }

            public final GuildRole getRole() {
                return this.role;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                StoreVoiceParticipants.VoiceUser voiceUser = this.participant;
                int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
                UtcDateTime utcDateTime = this.requestToSpeakTimestamp;
                int iHashCode2 = (iHashCode + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
                GuildMember guildMember = this.member;
                int iHashCode3 = (iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                GuildRole guildRole = this.role;
                return iHashCode3 + (guildRole != null ? guildRole.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Participant(participant=");
                sbU.append(this.participant);
                sbU.append(", requestToSpeakTimestamp=");
                sbU.append(this.requestToSpeakTimestamp);
                sbU.append(", member=");
                sbU.append(this.member);
                sbU.append(", role=");
                sbU.append(this.role);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ListItem() {
        }

        public /* synthetic */ ListItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter;", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem;", "Landroid/content/Context;", "context", "Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant;", "data", "", "getParticipantMemberInfo", "(Landroid/content/Context;Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant;)Ljava/lang/String;", "Lcom/discord/models/user/User;", "user", "", "isNewUser", "(Lcom/discord/models/user/User;)Z", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "", "onConfigure", "(ILcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter$ListItem;)V", "Lcom/discord/databinding/StageRaisedHandsItemUserBinding;", "binding", "Lcom/discord/databinding/StageRaisedHandsItemUserBinding;", "adapter", "<init>", "(Lcom/discord/widgets/stage/sheet/WidgetStageRaisedHandsBottomSheetAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolderParticipant extends MGRecyclerViewHolder<WidgetStageRaisedHandsBottomSheetAdapter, ListItem> {
        private final StageRaisedHandsItemUserBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolderParticipant(WidgetStageRaisedHandsBottomSheetAdapter widgetStageRaisedHandsBottomSheetAdapter) {
            super(R.layout.stage_raised_hands_item_user, widgetStageRaisedHandsBottomSheetAdapter);
            Intrinsics3.checkNotNullParameter(widgetStageRaisedHandsBottomSheetAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.stage_raised_hands_item_dismiss_button;
            ImageView imageView = (ImageView) view.findViewById(R.id.stage_raised_hands_item_dismiss_button);
            if (imageView != null) {
                i = R.id.stage_raised_hands_item_invite_button;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.stage_raised_hands_item_invite_button);
                if (imageView2 != null) {
                    i = R.id.stage_raised_hands_item_role;
                    TextView textView = (TextView) view.findViewById(R.id.stage_raised_hands_item_role);
                    if (textView != null) {
                        i = R.id.stage_raised_hands_item_user_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.stage_raised_hands_item_user_avatar);
                        if (simpleDraweeView != null) {
                            i = R.id.stage_raised_hands_item_user_name;
                            TextView textView2 = (TextView) view.findViewById(R.id.stage_raised_hands_item_user_name);
                            if (textView2 != null) {
                                StageRaisedHandsItemUserBinding stageRaisedHandsItemUserBinding = new StageRaisedHandsItemUserBinding((ConstraintLayout) view, imageView, imageView2, textView, simpleDraweeView, textView2);
                                Intrinsics3.checkNotNullExpressionValue(stageRaisedHandsItemUserBinding, "StageRaisedHandsItemUserBinding.bind(itemView)");
                                this.binding = stageRaisedHandsItemUserBinding;
                                return;
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter access$getAdapter$p(ViewHolderParticipant viewHolderParticipant) {
            return (WidgetStageRaisedHandsBottomSheetAdapter) viewHolderParticipant.adapter;
        }

        private final String getParticipantMemberInfo(Context context, ListItem.Participant data) {
            String name;
            if (isNewUser(data.getParticipant().getUser())) {
                String string = context.getString(R.string.request_to_speak_member_info_new_to_discord);
                Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…mber_info_new_to_discord)");
                return string;
            }
            GuildMember member = data.getMember();
            UtcDateTime joinedAt = member != null ? member.getJoinedAt() : null;
            if (joinedAt == null) {
                String string2 = context.getString(R.string.request_to_speak_member_info_non_member);
                Intrinsics3.checkNotNullExpressionValue(string2, "context.getString(R.stri…k_member_info_non_member)");
                return string2;
            }
            if (!data.getMember().getRoles().isEmpty()) {
                GuildRole role = data.getRole();
                if (role != null && (name = role.getName()) != null) {
                    return name;
                }
                String string3 = context.getString(R.string.request_to_speak_member_info_member_roles);
                Intrinsics3.checkNotNullExpressionValue(string3, "context.getString(R.stri…member_info_member_roles)");
                return string3;
            }
            if (ClockFactory.get().currentTimeMillis() - joinedAt.getDateTimeMillis() < WidgetStageRaisedHandsBottomSheetAdapter.MILLIS_PER_DAY) {
                String string4 = context.getString(R.string.request_to_speak_member_info_new_member);
                Intrinsics3.checkNotNullExpressionValue(string4, "context.getString(R.stri…k_member_info_new_member)");
                return string4;
            }
            String string5 = context.getString(R.string.request_to_speak_member_info_member);
            Intrinsics3.checkNotNullExpressionValue(string5, "context.getString(R.stri…speak_member_info_member)");
            return string5;
        }

        private final boolean isNewUser(User user) {
            return ClockFactory.get().currentTimeMillis() - ((user.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH) <= ((long) 604800000);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, ListItem listItem) throws Resources.NotFoundException {
            onConfigure2(i, listItem);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, ListItem data) throws Resources.NotFoundException {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            ListItem.Participant participant = (ListItem.Participant) data;
            StoreVoiceParticipants.VoiceUser participant2 = participant.getParticipant();
            GuildMember member = participant.getMember();
            this.binding.e.setOnClickListener(new WidgetStageRaisedHandsBottomSheetAdapter3(this, participant2));
            ImageView imageView = this.binding.c;
            ViewExtensions.setEnabledAndAlpha$default(imageView, !participant2.getIsInvitedToSpeak(), 0.0f, 2, null);
            imageView.setOnClickListener(new WidgetStageRaisedHandsBottomSheetAdapter2(this, participant2));
            this.binding.f2146b.setOnClickListener(new WidgetStageRaisedHandsBottomSheetAdapter4(this, participant2));
            SimpleDraweeView simpleDraweeView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stageRaisedHandsItemUserAvatar");
            SimpleDraweeViewExtensions.setAvatar$default(simpleDraweeView, participant2.getUser(), false, R.dimen.avatar_size_standard, participant2.getGuildMember(), 2, null);
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.stageRaisedHandsItemUserName");
            textView.setText(participant2.getDisplayName());
            if (member != null && member.getColor() != -16777216) {
                this.binding.f.setTextColor(member.getColor());
            }
            TextView textView2 = this.binding.d;
            Context context = textView2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            textView2.setText(getParticipantMemberInfo(context, participant));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageRaisedHandsBottomSheetAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onViewProfile = WidgetStageRaisedHandsBottomSheetAdapter7.INSTANCE;
        this.onInviteToSpeak = WidgetStageRaisedHandsBottomSheetAdapter6.INSTANCE;
        this.onDismissRequest = WidgetStageRaisedHandsBottomSheetAdapter5.INSTANCE;
    }

    public final Function1<StoreVoiceParticipants.VoiceUser, Unit> getOnDismissRequest() {
        return this.onDismissRequest;
    }

    public final Function1<StoreVoiceParticipants.VoiceUser, Unit> getOnInviteToSpeak() {
        return this.onInviteToSpeak;
    }

    public final Function1<StoreVoiceParticipants.VoiceUser, Unit> getOnViewProfile() {
        return this.onViewProfile;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnDismissRequest(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onDismissRequest = function1;
    }

    public final void setOnInviteToSpeak(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onInviteToSpeak = function1;
    }

    public final void setOnViewProfile(Function1<? super StoreVoiceParticipants.VoiceUser, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.onViewProfile = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ListItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ViewHolderParticipant(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
