package com.discord.widgets.voice.fullscreen;

import b.d.b.a.outline;
import com.discord.api.application.ApplicationAsset;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.embeddedactivities.EmbeddedActivity;
import com.discord.models.guild.UserGuildMember;
import com.discord.views.calls.VideoCallParticipantView;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CallParticipant.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/CallParticipant;", "", "", "hasActiveVideo", "()Z", "", "getId", "()Ljava/lang/String;", ModelAuditLogEntry.CHANGE_KEY_ID, "<init>", "()V", "EmbeddedActivityParticipant", "UserOrStreamParticipant", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant$EmbeddedActivityParticipant;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public abstract class CallParticipant {

    /* compiled from: CallParticipant.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J@\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00052\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0014\u001a\u00020\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b \u0010!R\u0019\u0010\u0014\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\"\u001a\u0004\b#\u0010\u000eR\u001c\u0010$\u001a\u00020\u00188\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u001aR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010'\u001a\u0004\b(\u0010\u0007R\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b*\u0010\u000bR\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u0011¨\u0006/"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/CallParticipant$EmbeddedActivityParticipant;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant;", "", "hasActiveVideo", "()Z", "Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "component1", "()Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "", "Lcom/discord/models/guild/UserGuildMember;", "component2", "()Ljava/util/List;", "Lcom/discord/models/commands/Application;", "component3", "()Lcom/discord/models/commands/Application;", "Lcom/discord/api/application/ApplicationAsset;", "component4", "()Lcom/discord/api/application/ApplicationAsset;", "embeddedActivity", "participantsInActivity", "application", "backgroundAsset", "copy", "(Lcom/discord/models/embeddedactivities/EmbeddedActivity;Ljava/util/List;Lcom/discord/models/commands/Application;Lcom/discord/api/application/ApplicationAsset;)Lcom/discord/widgets/voice/fullscreen/CallParticipant$EmbeddedActivityParticipant;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/commands/Application;", "getApplication", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/String;", "getId", "Lcom/discord/models/embeddedactivities/EmbeddedActivity;", "getEmbeddedActivity", "Ljava/util/List;", "getParticipantsInActivity", "Lcom/discord/api/application/ApplicationAsset;", "getBackgroundAsset", "<init>", "(Lcom/discord/models/embeddedactivities/EmbeddedActivity;Ljava/util/List;Lcom/discord/models/commands/Application;Lcom/discord/api/application/ApplicationAsset;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class EmbeddedActivityParticipant extends CallParticipant {
        private final Application application;
        private final ApplicationAsset backgroundAsset;
        private final EmbeddedActivity embeddedActivity;
        private final String id;
        private final List<UserGuildMember> participantsInActivity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmbeddedActivityParticipant(EmbeddedActivity embeddedActivity, List<UserGuildMember> list, Application application, ApplicationAsset applicationAsset) {
            super(null);
            Intrinsics3.checkNotNullParameter(embeddedActivity, "embeddedActivity");
            Intrinsics3.checkNotNullParameter(list, "participantsInActivity");
            Intrinsics3.checkNotNullParameter(application, "application");
            this.embeddedActivity = embeddedActivity;
            this.participantsInActivity = list;
            this.application = application;
            this.backgroundAsset = applicationAsset;
            this.id = String.valueOf(application.getId());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ EmbeddedActivityParticipant copy$default(EmbeddedActivityParticipant embeddedActivityParticipant, EmbeddedActivity embeddedActivity, List list, Application application, ApplicationAsset applicationAsset, int i, Object obj) {
            if ((i & 1) != 0) {
                embeddedActivity = embeddedActivityParticipant.embeddedActivity;
            }
            if ((i & 2) != 0) {
                list = embeddedActivityParticipant.participantsInActivity;
            }
            if ((i & 4) != 0) {
                application = embeddedActivityParticipant.application;
            }
            if ((i & 8) != 0) {
                applicationAsset = embeddedActivityParticipant.backgroundAsset;
            }
            return embeddedActivityParticipant.copy(embeddedActivity, list, application, applicationAsset);
        }

        /* renamed from: component1, reason: from getter */
        public final EmbeddedActivity getEmbeddedActivity() {
            return this.embeddedActivity;
        }

        public final List<UserGuildMember> component2() {
            return this.participantsInActivity;
        }

        /* renamed from: component3, reason: from getter */
        public final Application getApplication() {
            return this.application;
        }

        /* renamed from: component4, reason: from getter */
        public final ApplicationAsset getBackgroundAsset() {
            return this.backgroundAsset;
        }

        public final EmbeddedActivityParticipant copy(EmbeddedActivity embeddedActivity, List<UserGuildMember> participantsInActivity, Application application, ApplicationAsset backgroundAsset) {
            Intrinsics3.checkNotNullParameter(embeddedActivity, "embeddedActivity");
            Intrinsics3.checkNotNullParameter(participantsInActivity, "participantsInActivity");
            Intrinsics3.checkNotNullParameter(application, "application");
            return new EmbeddedActivityParticipant(embeddedActivity, participantsInActivity, application, backgroundAsset);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EmbeddedActivityParticipant)) {
                return false;
            }
            EmbeddedActivityParticipant embeddedActivityParticipant = (EmbeddedActivityParticipant) other;
            return Intrinsics3.areEqual(this.embeddedActivity, embeddedActivityParticipant.embeddedActivity) && Intrinsics3.areEqual(this.participantsInActivity, embeddedActivityParticipant.participantsInActivity) && Intrinsics3.areEqual(this.application, embeddedActivityParticipant.application) && Intrinsics3.areEqual(this.backgroundAsset, embeddedActivityParticipant.backgroundAsset);
        }

        public final Application getApplication() {
            return this.application;
        }

        public final ApplicationAsset getBackgroundAsset() {
            return this.backgroundAsset;
        }

        public final EmbeddedActivity getEmbeddedActivity() {
            return this.embeddedActivity;
        }

        @Override // com.discord.widgets.voice.fullscreen.CallParticipant
        public String getId() {
            return this.id;
        }

        public final List<UserGuildMember> getParticipantsInActivity() {
            return this.participantsInActivity;
        }

        @Override // com.discord.widgets.voice.fullscreen.CallParticipant
        public boolean hasActiveVideo() {
            return false;
        }

        public int hashCode() {
            EmbeddedActivity embeddedActivity = this.embeddedActivity;
            int iHashCode = (embeddedActivity != null ? embeddedActivity.hashCode() : 0) * 31;
            List<UserGuildMember> list = this.participantsInActivity;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            Application application = this.application;
            int iHashCode3 = (iHashCode2 + (application != null ? application.hashCode() : 0)) * 31;
            ApplicationAsset applicationAsset = this.backgroundAsset;
            return iHashCode3 + (applicationAsset != null ? applicationAsset.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("EmbeddedActivityParticipant(embeddedActivity=");
            sbU.append(this.embeddedActivity);
            sbU.append(", participantsInActivity=");
            sbU.append(this.participantsInActivity);
            sbU.append(", application=");
            sbU.append(this.application);
            sbU.append(", backgroundAsset=");
            sbU.append(this.backgroundAsset);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: CallParticipant.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u000b8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\rR\u0019\u0010\b\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "Lcom/discord/widgets/voice/fullscreen/CallParticipant;", "", "hasActiveVideo", "()Z", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "component1", "()Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "participantData", "copy", "(Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;)Lcom/discord/widgets/voice/fullscreen/CallParticipant$UserOrStreamParticipant;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", ModelAuditLogEntry.CHANGE_KEY_ID, "Ljava/lang/String;", "getId", "Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;", "getParticipantData", "<init>", "(Lcom/discord/views/calls/VideoCallParticipantView$ParticipantData;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class UserOrStreamParticipant extends CallParticipant {
        private final String id;
        private final VideoCallParticipantView.ParticipantData participantData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserOrStreamParticipant(VideoCallParticipantView.ParticipantData participantData) {
            super(null);
            Intrinsics3.checkNotNullParameter(participantData, "participantData");
            this.participantData = participantData;
            this.id = participantData.id;
        }

        public static /* synthetic */ UserOrStreamParticipant copy$default(UserOrStreamParticipant userOrStreamParticipant, VideoCallParticipantView.ParticipantData participantData, int i, Object obj) {
            if ((i & 1) != 0) {
                participantData = userOrStreamParticipant.participantData;
            }
            return userOrStreamParticipant.copy(participantData);
        }

        /* renamed from: component1, reason: from getter */
        public final VideoCallParticipantView.ParticipantData getParticipantData() {
            return this.participantData;
        }

        public final UserOrStreamParticipant copy(VideoCallParticipantView.ParticipantData participantData) {
            Intrinsics3.checkNotNullParameter(participantData, "participantData");
            return new UserOrStreamParticipant(participantData);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof UserOrStreamParticipant) && Intrinsics3.areEqual(this.participantData, ((UserOrStreamParticipant) other).participantData);
            }
            return true;
        }

        @Override // com.discord.widgets.voice.fullscreen.CallParticipant
        public String getId() {
            return this.id;
        }

        public final VideoCallParticipantView.ParticipantData getParticipantData() {
            return this.participantData;
        }

        @Override // com.discord.widgets.voice.fullscreen.CallParticipant
        public boolean hasActiveVideo() {
            VideoCallParticipantView.ParticipantData participantData = this.participantData;
            VoiceState voiceState = participantData.voiceParticipant.getVoiceState();
            return (voiceState != null && voiceState.getSelfVideo()) || participantData.applicationStreamState != null;
        }

        public int hashCode() {
            VideoCallParticipantView.ParticipantData participantData = this.participantData;
            if (participantData != null) {
                return participantData.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("UserOrStreamParticipant(participantData=");
            sbU.append(this.participantData);
            sbU.append(")");
            return sbU.toString();
        }
    }

    private CallParticipant() {
    }

    public abstract String getId();

    public abstract boolean hasActiveVideo();

    public /* synthetic */ CallParticipant(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
