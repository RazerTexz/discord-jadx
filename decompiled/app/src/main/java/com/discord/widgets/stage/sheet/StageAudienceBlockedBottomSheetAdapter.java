package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.StageAudienceBlockedBottomSheetHeaderItemBinding;
import com.discord.databinding.StageAudienceBlockedBottomSheetItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.views.CutoutView;
import com.discord.widgets.user.UserNameFormatter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0011\u0012\u0013\u0014B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", ModelAuditLogEntry.CHANGE_KEY_POSITION, "getItemViewType", "(I)I", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Companion", "HeaderViewHolder", "ListItem", "ParticipantViewHolder", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_PARTICIPANT = 1;

    /* compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$HeaderViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/StageAudienceBlockedBottomSheetHeaderItemBinding;", "binding", "Lcom/discord/databinding/StageAudienceBlockedBottomSheetHeaderItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<StageAudienceBlockedBottomSheetAdapter, MGRecyclerDataPayload> {
        private final StageAudienceBlockedBottomSheetHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter) {
            super(R.layout.stage_audience_blocked_bottom_sheet_header_item, stageAudienceBlockedBottomSheetAdapter);
            Intrinsics3.checkNotNullParameter(stageAudienceBlockedBottomSheetAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.description;
            MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.description);
            if (materialTextView != null) {
                i = R.id.title;
                MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(R.id.title);
                if (materialTextView2 != null) {
                    StageAudienceBlockedBottomSheetHeaderItemBinding stageAudienceBlockedBottomSheetHeaderItemBinding = new StageAudienceBlockedBottomSheetHeaderItemBinding((ConstraintLayout) view, materialTextView, materialTextView2);
                    Intrinsics3.checkNotNullExpressionValue(stageAudienceBlockedBottomSheetHeaderItemBinding, "StageAudienceBlockedBott…temBinding.bind(itemView)");
                    this.binding = stageAudienceBlockedBottomSheetHeaderItemBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (data instanceof ListItem.Header) {
                MaterialTextView materialTextView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.title");
                ListItem.Header header = (ListItem.Header) data;
                materialTextView.setText(FormatUtils.h(outline.x(this.itemView, "itemView", "itemView.context"), R.string.stage_blocked_users_title_plural, new Object[]{StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.stage_blocked_users_title_plural_number, header.getNumBlockedUsers(), new Object[0])}, null, 4));
                MaterialTextView materialTextView2 = this.binding.f2144b;
                Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.description");
                materialTextView2.setText(FormatUtils.h(outline.x(this.itemView, "itemView", "itemView.context"), R.string.stage_blocked_users_body, new Object[]{StringResourceUtils.getI18nPluralString(outline.x(this.itemView, "itemView", "itemView.context"), R.plurals.stage_blocked_users_body_number, header.getNumBlockedUsers(), Integer.valueOf(header.getNumBlockedUsers()))}, null, 4));
            }
        }
    }

    /* compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ListItem;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "<init>", "()V", Traits.Location.Section.HEADER, "Participant", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ListItem$Participant;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ListItem$Header;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ListItem implements MGRecyclerDataPayload {

        /* compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\b8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ListItem$Header;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ListItem;", "", "component1", "()I", "numBlockedUsers", "copy", "(I)Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ListItem$Header;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "getNumBlockedUsers", "key", "Ljava/lang/String;", "getKey", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Header extends ListItem {
            private final String key;
            private final int numBlockedUsers;
            private final int type;

            public Header(int i) {
                super(null);
                this.numBlockedUsers = i;
                this.key = "AudienceBlockedHeader";
            }

            public static /* synthetic */ Header copy$default(Header header, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = header.numBlockedUsers;
                }
                return header.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getNumBlockedUsers() {
                return this.numBlockedUsers;
            }

            public final Header copy(int numBlockedUsers) {
                return new Header(numBlockedUsers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Header) && this.numBlockedUsers == ((Header) other).numBlockedUsers;
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getNumBlockedUsers() {
                return this.numBlockedUsers;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                return this.numBlockedUsers;
            }

            public String toString() {
                return outline.B(outline.U("Header(numBlockedUsers="), this.numBlockedUsers, ")");
            }
        }

        /* compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u00020\u000f8\u0016@\u0016X\u0096D¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0011R\u001c\u0010\u0019\u001a\u00020\f8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u000eR\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b\t\u0010\u0007¨\u0006!"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ListItem$Participant;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ListItem;", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "component1", "()Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "", "component2", "()Z", "participant", "isSpeaker", "copy", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Z)Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ListItem$Participant;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "type", "I", "getType", "key", "Ljava/lang/String;", "getKey", "Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;", "getParticipant", "Z", "<init>", "(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Participant extends ListItem {
            private final boolean isSpeaker;
            private final String key;
            private final StoreVoiceParticipants.VoiceUser participant;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Participant(StoreVoiceParticipants.VoiceUser voiceUser, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(voiceUser, "participant");
                this.participant = voiceUser;
                this.isSpeaker = z2;
                this.type = 1;
                this.key = String.valueOf(voiceUser.getUser().getId());
            }

            public static /* synthetic */ Participant copy$default(Participant participant, StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    voiceUser = participant.participant;
                }
                if ((i & 2) != 0) {
                    z2 = participant.isSpeaker;
                }
                return participant.copy(voiceUser, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getIsSpeaker() {
                return this.isSpeaker;
            }

            public final Participant copy(StoreVoiceParticipants.VoiceUser participant, boolean isSpeaker) {
                Intrinsics3.checkNotNullParameter(participant, "participant");
                return new Participant(participant, isSpeaker);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Participant)) {
                    return false;
                }
                Participant participant = (Participant) other;
                return Intrinsics3.areEqual(this.participant, participant.participant) && this.isSpeaker == participant.isSpeaker;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                StoreVoiceParticipants.VoiceUser voiceUser = this.participant;
                int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
                boolean z2 = this.isSpeaker;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode + i;
            }

            public final boolean isSpeaker() {
                return this.isSpeaker;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Participant(participant=");
                sbU.append(this.participant);
                sbU.append(", isSpeaker=");
                return outline.O(sbU, this.isSpeaker, ")");
            }
        }

        private ListItem() {
        }

        public /* synthetic */ ListItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter$ParticipantViewHolder;", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;", "", ModelAuditLogEntry.CHANGE_KEY_POSITION, "data", "", "onConfigure", "(ILcom/discord/utilities/mg_recycler/MGRecyclerDataPayload;)V", "Lcom/discord/databinding/StageAudienceBlockedBottomSheetItemBinding;", "binding", "Lcom/discord/databinding/StageAudienceBlockedBottomSheetItemBinding;", "adapter", "<init>", "(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetAdapter;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ParticipantViewHolder extends MGRecyclerViewHolder<StageAudienceBlockedBottomSheetAdapter, MGRecyclerDataPayload> {
        private final StageAudienceBlockedBottomSheetItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParticipantViewHolder(StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter) {
            super(R.layout.stage_audience_blocked_bottom_sheet_item, stageAudienceBlockedBottomSheetAdapter);
            Intrinsics3.checkNotNullParameter(stageAudienceBlockedBottomSheetAdapter, "adapter");
            View view = this.itemView;
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i = R.id.stage_channel_blocked_member_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.stage_channel_blocked_member_icon);
            if (simpleDraweeView != null) {
                i = R.id.stage_channel_blocked_member_icon_container;
                CutoutView cutoutView = (CutoutView) view.findViewById(R.id.stage_channel_blocked_member_icon_container);
                if (cutoutView != null) {
                    i = R.id.stage_channel_blocked_member_name;
                    TextView textView = (TextView) view.findViewById(R.id.stage_channel_blocked_member_name);
                    if (textView != null) {
                        i = R.id.stage_channel_blocked_member_speaker;
                        ImageView imageView = (ImageView) view.findViewById(R.id.stage_channel_blocked_member_speaker);
                        if (imageView != null) {
                            i = R.id.stage_channel_blocked_text;
                            TextView textView2 = (TextView) view.findViewById(R.id.stage_channel_blocked_text);
                            if (textView2 != null) {
                                i = R.id.stage_channel_blocked_text_divider;
                                View viewFindViewById = view.findViewById(R.id.stage_channel_blocked_text_divider);
                                if (viewFindViewById != null) {
                                    i = R.id.stage_channel_blocked_text_speaker;
                                    TextView textView3 = (TextView) view.findViewById(R.id.stage_channel_blocked_text_speaker);
                                    if (textView3 != null) {
                                        StageAudienceBlockedBottomSheetItemBinding stageAudienceBlockedBottomSheetItemBinding = new StageAudienceBlockedBottomSheetItemBinding((ConstraintLayout) view, constraintLayout, simpleDraweeView, cutoutView, textView, imageView, textView2, viewFindViewById, textView3);
                                        Intrinsics3.checkNotNullExpressionValue(stageAudienceBlockedBottomSheetItemBinding, "StageAudienceBlockedBott…temBinding.bind(itemView)");
                                        this.binding = stageAudienceBlockedBottomSheetItemBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
            onConfigure2(i, mGRecyclerDataPayload);
        }

        /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
        public void onConfigure2(int position, MGRecyclerDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, (int) data);
            if (data instanceof ListItem.Participant) {
                ListItem.Participant participant = (ListItem.Participant) data;
                this.binding.c.setCutoutEnabled(participant.isSpeaker());
                ImageView imageView = this.binding.e;
                imageView.setBackgroundResource(R.drawable.drawable_uikit_white_circle);
                imageView.setImageResource(R.drawable.ic_mic_grey_24dp);
                imageView.setVisibility(participant.isSpeaker() ? 0 : 4);
                imageView.setActivated(participant.isSpeaker());
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Resources resources = view.getResources();
                TextView textView = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.stageChannelBlockedTextSpeaker");
                textView.setText(participant.isSpeaker() ? resources.getString(R.string.stage_speaker) : resources.getString(R.string.stage_audience));
                TextView textView2 = this.binding.d;
                User user = participant.getParticipant().getUser();
                String nickname = participant.getParticipant().getNickname();
                Context context = textView2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                textView2.setText(UserNameFormatter.getSpannableForUserNameWithDiscrim(user, nickname, context, R.attr.colorHeaderPrimary, R.attr.font_primary_semibold, R.integer.uikit_textsize_large_sp, R.attr.colorTextMuted, R.attr.font_primary_normal, R.integer.uikit_textsize_medium_sp));
                SimpleDraweeView simpleDraweeView = this.binding.f2145b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.stageChannelBlockedMemberIcon");
                IconUtils.setIcon$default(simpleDraweeView, participant.getParticipant().getUser().getUsername(), Long.valueOf(participant.getParticipant().getUser().getId()), participant.getParticipant().getUser().getAvatar(), Integer.valueOf(R.dimen.avatar_size_large), 0, null, null, participant.getParticipant().getGuildMember(), 224, null);
                SimpleDraweeView simpleDraweeView2 = this.binding.f2145b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.stageChannelBlockedMemberIcon");
                simpleDraweeView2.setAlpha(0.5f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position != 0 ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new ParticipantViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
