package com.discord.widgets.servers.member_verification;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelMemberVerificationForm;
import com.discord.models.domain.ModelMemberVerificationFormResponse;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuildMemberVerificationForm;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItem;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemApproveTerms;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemHeader;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemMultipleChoice;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemParagraph;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTerm;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTermsHeader;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemTextInput;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetMemberVerificationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005NOPQRBq\u0012\n\u00106\u001a\u00060\u001aj\u0002`5\u0012\u0006\u0010G\u001a\u00020\u001c\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u000102\u0012\b\b\u0002\u0010J\u001a\u00020I\u0012\b\b\u0002\u0010B\u001a\u00020A\u0012$\b\u0002\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020908j\u0002`:\u0012\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020\u000b0$¢\u0006\u0004\bL\u0010MJ'\u0010\t\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005j\u0002`\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014Ja\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00152\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00122\u0016\u0010\u001d\u001a\u0012\u0012\b\u0012\u00060\u001aj\u0002`\u001b\u0012\u0004\u0012\u00020\u001c0\u00192\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001e0\u00192\u0006\u0010 \u001a\u00020\u0012H\u0002¢\u0006\u0004\b\"\u0010#J\u0013\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\r¢\u0006\u0004\b(\u0010\u0011J\u0015\u0010)\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0012¢\u0006\u0004\b)\u0010*J\u001f\u0010/\u001a\u00020\r2\u0006\u0010,\u001a\u00020+2\b\u0010.\u001a\u0004\u0018\u00010-¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\rH\u0014¢\u0006\u0004\b1\u0010\u0011R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u00106\u001a\u00060\u001aj\u0002`58\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R2\u0010;\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020908j\u0002`:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R:\u0010?\u001a&\u0012\f\u0012\n >*\u0004\u0018\u00010%0% >*\u0012\u0012\f\u0012\n >*\u0004\u0018\u00010%0%\u0018\u00010=0=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020A8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR$\u0010E\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010-0D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010G\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006S"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;", "", "rawRuleString", "", "Lcom/discord/simpleast/core/node/Node;", "Lcom/discord/utilities/textprocessing/MessageRenderContext;", "Lcom/discord/widgets/servers/member_verification/AST;", "generateAST", "(Ljava/lang/CharSequence;)Ljava/util/List;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$StoreState;)V", "handleGuildUpdateError", "()V", "", "isFormValid", "()Z", "", "Lcom/discord/models/domain/ModelMemberVerificationForm$FormField;", "formFields", "isTermsApproved", "", "", "Lcom/discord/primitives/ChannelId;", "", "channelNames", "Lcom/discord/api/role/GuildRole;", "roles", "allowAnimatedEmojis", "Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItem;", "createFormItems", "(Ljava/util/List;ZLjava/util/Map;Ljava/util/Map;Z)Ljava/util/List;", "Lrx/Observable;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event;", "observeEvents", "()Lrx/Observable;", "applyToJoinGuild", "updateTermsApproval", "(Z)V", "", "key", "", "value", "updateFormValidation", "(ILjava/lang/Object;)V", "onCleared", "Lcom/discord/models/guild/Guild;", "inviteGuild", "Lcom/discord/models/guild/Guild;", "Lcom/discord/primitives/GuildId;", "guildId", "J", "Lcom/discord/simpleast/core/parser/Parser;", "Lcom/discord/utilities/textprocessing/MessageParseState;", "Lcom/discord/widgets/servers/member_verification/RulesParser;", "rulesParser", "Lcom/discord/simpleast/core/parser/Parser;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "", "formUserInputDataMap", "Ljava/util/Map;", ModelAuditLogEntry.CHANGE_KEY_LOCATION, "Ljava/lang/String;", "Lcom/discord/stores/StoreGuildMemberVerificationForm;", "storeGuildMemberVerificationForm", "storeObservable", "<init>", "(JLjava/lang/String;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildMemberVerificationForm;Lcom/discord/utilities/rest/RestAPI;Lcom/discord/simpleast/core/parser/Parser;Lrx/Observable;)V", "Companion", "Event", "StoreState", "VerificationType", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetMemberVerificationViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final Map<Integer, Object> formUserInputDataMap;
    private final long guildId;
    private final Guild inviteGuild;
    private final String location;
    private final RestAPI restAPI;
    private final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> rulesParser;

    /* compiled from: WidgetMemberVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$StoreState;", "storeState", "", "invoke", "(Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetMemberVerificationViewModel.access$handleStoreState(WidgetMemberVerificationViewModel.this, storeState);
        }
    }

    /* compiled from: WidgetMemberVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Companion;", "", "", "Lcom/discord/primitives/GuildId;", "guildId", "Lcom/discord/models/guild/Guild;", "inviteGuild", "Lrx/Observable;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$StoreState;", "observeStores", "(JLcom/discord/models/guild/Guild;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public final Observable<StoreState> observeStores(long guildId, Guild inviteGuild) {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable<StoreState> observableF = Observable.f(companion.getUsers().observeMe(true), companion.getGuilds().observeGuild(guildId), companion.getMemberVerificationForms().observeMemberVerificationFormData(guildId), companion.getChannels().observeNames(), companion.getGuilds().observeRoles(guildId), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(companion.getUserSettings(), false, 1, null), new WidgetMemberVerificationViewModel2(inviteGuild));
            Intrinsics3.checkNotNullExpressionValue(observableF, "Observable\n            .…          )\n            }");
            return observableF;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetMemberVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event;", "", "<init>", "()V", "Error", "Success", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event$Success;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event$Error;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetMemberVerificationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event$Error;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends Event {
            public static final Error INSTANCE = new Error();

            private Error() {
                super(null);
            }
        }

        /* compiled from: WidgetMemberVerificationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b#\u0010$J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\f\u0010\bJD\u0010\u0011\u001a\u00020\u00002\u0010\b\u0002\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u000f\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u000bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\bR!\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0005R\u001b\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event$Success;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event;", "", "Lcom/discord/primitives/GuildId;", "component1", "()Ljava/lang/Long;", "", "component2", "()Ljava/lang/String;", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "component3", "()Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "component4", "guildId", "guildName", "applicationStatus", "lastSeen", "copy", "(Ljava/lang/Long;Ljava/lang/String;Lcom/discord/api/guildjoinrequest/ApplicationStatus;Ljava/lang/String;)Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$Event$Success;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/api/guildjoinrequest/ApplicationStatus;", "getApplicationStatus", "Ljava/lang/String;", "getGuildName", "Ljava/lang/Long;", "getGuildId", "getLastSeen", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Lcom/discord/api/guildjoinrequest/ApplicationStatus;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Success extends Event {
            private final ApplicationStatus applicationStatus;
            private final Long guildId;
            private final String guildName;
            private final String lastSeen;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(Long l, String str, ApplicationStatus applicationStatus, String str2) {
                super(null);
                Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
                this.guildId = l;
                this.guildName = str;
                this.applicationStatus = applicationStatus;
                this.lastSeen = str2;
            }

            public static /* synthetic */ Success copy$default(Success success, Long l, String str, ApplicationStatus applicationStatus, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = success.guildId;
                }
                if ((i & 2) != 0) {
                    str = success.guildName;
                }
                if ((i & 4) != 0) {
                    applicationStatus = success.applicationStatus;
                }
                if ((i & 8) != 0) {
                    str2 = success.lastSeen;
                }
                return success.copy(l, str, applicationStatus, str2);
            }

            /* renamed from: component1, reason: from getter */
            public final Long getGuildId() {
                return this.guildId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getGuildName() {
                return this.guildName;
            }

            /* renamed from: component3, reason: from getter */
            public final ApplicationStatus getApplicationStatus() {
                return this.applicationStatus;
            }

            /* renamed from: component4, reason: from getter */
            public final String getLastSeen() {
                return this.lastSeen;
            }

            public final Success copy(Long guildId, String guildName, ApplicationStatus applicationStatus, String lastSeen) {
                Intrinsics3.checkNotNullParameter(applicationStatus, "applicationStatus");
                return new Success(guildId, guildName, applicationStatus, lastSeen);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Success)) {
                    return false;
                }
                Success success = (Success) other;
                return Intrinsics3.areEqual(this.guildId, success.guildId) && Intrinsics3.areEqual(this.guildName, success.guildName) && Intrinsics3.areEqual(this.applicationStatus, success.applicationStatus) && Intrinsics3.areEqual(this.lastSeen, success.lastSeen);
            }

            public final ApplicationStatus getApplicationStatus() {
                return this.applicationStatus;
            }

            public final Long getGuildId() {
                return this.guildId;
            }

            public final String getGuildName() {
                return this.guildName;
            }

            public final String getLastSeen() {
                return this.lastSeen;
            }

            public int hashCode() {
                Long l = this.guildId;
                int iHashCode = (l != null ? l.hashCode() : 0) * 31;
                String str = this.guildName;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                ApplicationStatus applicationStatus = this.applicationStatus;
                int iHashCode3 = (iHashCode2 + (applicationStatus != null ? applicationStatus.hashCode() : 0)) * 31;
                String str2 = this.lastSeen;
                return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Success(guildId=");
                sbU.append(this.guildId);
                sbU.append(", guildName=");
                sbU.append(this.guildName);
                sbU.append(", applicationStatus=");
                sbU.append(this.applicationStatus);
                sbU.append(", lastSeen=");
                return outline.J(sbU, this.lastSeen, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetMemberVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\b\u0012\u0016\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u0013¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u000bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u0010\u0010\u0014\u001a\u00020\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015Jl\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\u0018\b\u0002\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000b2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u0013HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010$\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R)\u0010\u0019\u001a\u0012\u0012\b\u0012\u00060\fj\u0002`\r\u0012\u0004\u0012\u00020\u000e0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010&\u001a\u0004\b'\u0010\u0010R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b)\u0010\u0007R%\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00110\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010&\u001a\u0004\b*\u0010\u0010R\u0019\u0010\u0016\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b,\u0010\u0004R\u0019\u0010\u001b\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010-\u001a\u0004\b.\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u0010\n¨\u00063"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$StoreState;", "", "Lcom/discord/models/user/MeUser;", "component1", "()Lcom/discord/models/user/MeUser;", "Lcom/discord/models/guild/Guild;", "component2", "()Lcom/discord/models/guild/Guild;", "Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "component3", "()Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "", "", "Lcom/discord/primitives/ChannelId;", "", "component4", "()Ljava/util/Map;", "Lcom/discord/api/role/GuildRole;", "component5", "", "component6", "()Z", "me", "guild", "memberVerificationFormData", "channels", "roles", "allowAnimatedEmojis", "copy", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;Ljava/util/Map;Ljava/util/Map;Z)Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$StoreState;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getChannels", "Lcom/discord/models/guild/Guild;", "getGuild", "getRoles", "Lcom/discord/models/user/MeUser;", "getMe", "Z", "getAllowAnimatedEmojis", "Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;", "getMemberVerificationFormData", "<init>", "(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;Lcom/discord/stores/StoreGuildMemberVerificationForm$MemberVerificationFormData;Ljava/util/Map;Ljava/util/Map;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final boolean allowAnimatedEmojis;
        private final Map<Long, String> channels;
        private final Guild guild;
        private final MeUser me;
        private final StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData;
        private final Map<Long, GuildRole> roles;

        public StoreState(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, String> map, Map<Long, GuildRole> map2, boolean z2) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(map, "channels");
            Intrinsics3.checkNotNullParameter(map2, "roles");
            this.me = meUser;
            this.guild = guild;
            this.memberVerificationFormData = memberVerificationFormData;
            this.channels = map;
            this.roles = map2;
            this.allowAnimatedEmojis = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map map, Map map2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = storeState.me;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            Guild guild2 = guild;
            if ((i & 4) != 0) {
                memberVerificationFormData = storeState.memberVerificationFormData;
            }
            StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData2 = memberVerificationFormData;
            if ((i & 8) != 0) {
                map = storeState.channels;
            }
            Map map3 = map;
            if ((i & 16) != 0) {
                map2 = storeState.roles;
            }
            Map map4 = map2;
            if ((i & 32) != 0) {
                z2 = storeState.allowAnimatedEmojis;
            }
            return storeState.copy(meUser, guild2, memberVerificationFormData2, map3, map4, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component3, reason: from getter */
        public final StoreGuildMemberVerificationForm.MemberVerificationFormData getMemberVerificationFormData() {
            return this.memberVerificationFormData;
        }

        public final Map<Long, String> component4() {
            return this.channels;
        }

        public final Map<Long, GuildRole> component5() {
            return this.roles;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        public final StoreState copy(MeUser me2, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, String> channels, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(roles, "roles");
            return new StoreState(me2, guild, memberVerificationFormData, channels, roles, allowAnimatedEmojis);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.memberVerificationFormData, storeState.memberVerificationFormData) && Intrinsics3.areEqual(this.channels, storeState.channels) && Intrinsics3.areEqual(this.roles, storeState.roles) && this.allowAnimatedEmojis == storeState.allowAnimatedEmojis;
        }

        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        public final Map<Long, String> getChannels() {
            return this.channels;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final StoreGuildMemberVerificationForm.MemberVerificationFormData getMemberVerificationFormData() {
            return this.memberVerificationFormData;
        }

        public final Map<Long, GuildRole> getRoles() {
            return this.roles;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData = this.memberVerificationFormData;
            int iHashCode3 = (iHashCode2 + (memberVerificationFormData != null ? memberVerificationFormData.hashCode() : 0)) * 31;
            Map<Long, String> map = this.channels;
            int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, GuildRole> map2 = this.roles;
            int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.allowAnimatedEmojis;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode5 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(me=");
            sbU.append(this.me);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", memberVerificationFormData=");
            sbU.append(this.memberVerificationFormData);
            sbU.append(", channels=");
            sbU.append(this.channels);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", allowAnimatedEmojis=");
            return outline.O(sbU, this.allowAnimatedEmojis, ")");
        }
    }

    /* compiled from: WidgetMemberVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$VerificationType;", "", "<init>", "(Ljava/lang/String;I)V", "PHONE", "EMAIL", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum VerificationType {
        PHONE,
        EMAIL
    }

    /* compiled from: WidgetMemberVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;", "", "<init>", "()V", "Invalid", "Loaded", "Loading", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState$Invalid;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState$Loaded;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {

        /* compiled from: WidgetMemberVerificationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState$Invalid;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: WidgetMemberVerificationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010$\u001a\u00020\u0002\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\u0016\u0010'\u001a\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\u00150\u0012\u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u0012\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\b\u0010,\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\bH\u0010IJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J \u0010\u0016\u001a\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\u00150\u0012HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u0012HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJº\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010$\u001a\u00020\u00022\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\u0018\b\u0002\u0010'\u001a\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\u00150\u00122\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u00122\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u001dHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u001a\u00106\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u000104HÖ\u0003¢\u0006\u0004\b6\u00107R\u0019\u0010*\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u00108\u001a\u0004\b*\u0010\u0004R\u0019\u0010!\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b!\u00108\u001a\u0004\b9\u0010\u0004R\u001b\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010:\u001a\u0004\b;\u0010\u0011R\u0019\u0010 \u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u00108\u001a\u0004\b \u0010\u0004R\u001b\u0010,\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010<\u001a\u0004\b=\u0010\u001fR\u001b\u0010#\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010>\u001a\u0004\b?\u0010\tR\u001f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010@\u001a\u0004\bA\u0010\u000eR%\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00180\u00128\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010B\u001a\u0004\bC\u0010\u0017R\u0019\u0010$\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u00108\u001a\u0004\bD\u0010\u0004R)\u0010'\u001a\u0012\u0012\b\u0012\u00060\u0013j\u0002`\u0014\u0012\u0004\u0012\u00020\u00150\u00128\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010B\u001a\u0004\bE\u0010\u0017R\u0019\u0010+\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u00108\u001a\u0004\b+\u0010\u0004R\u0019\u0010)\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b)\u00108\u001a\u0004\bF\u0010\u0004R\u0019\u0010\"\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u00108\u001a\u0004\bG\u0010\u0004¨\u0006J"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState$Loaded;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;", "", "component1", "()Z", "component2", "component3", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$VerificationType;", "component4", "()Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$VerificationType;", "component5", "", "Lcom/discord/widgets/servers/member_verification/form_fields/MemberVerificationItem;", "component6", "()Ljava/util/List;", "Lcom/discord/models/domain/ModelMemberVerificationForm;", "component7", "()Lcom/discord/models/domain/ModelMemberVerificationForm;", "", "", "Lcom/discord/primitives/ChannelId;", "", "component8", "()Ljava/util/Map;", "Lcom/discord/api/role/GuildRole;", "component9", "component10", "component11", "component12", "Lcom/discord/models/guild/Guild;", "component13", "()Lcom/discord/models/guild/Guild;", "isRulesListVisible", "submitting", "disabled", "verificationType", "needsAdditionalVerification", "formItems", "form", "channelNames", "roles", "allowAnimatedEmojis", "isFormValid", "isTermsApproved", "guild", "copy", "(ZZZLcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$VerificationType;ZLjava/util/List;Lcom/discord/models/domain/ModelMemberVerificationForm;Ljava/util/Map;Ljava/util/Map;ZZZLcom/discord/models/guild/Guild;)Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState$Loaded;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSubmitting", "Lcom/discord/models/domain/ModelMemberVerificationForm;", "getForm", "Lcom/discord/models/guild/Guild;", "getGuild", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$VerificationType;", "getVerificationType", "Ljava/util/List;", "getFormItems", "Ljava/util/Map;", "getRoles", "getNeedsAdditionalVerification", "getChannelNames", "getAllowAnimatedEmojis", "getDisabled", "<init>", "(ZZZLcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$VerificationType;ZLjava/util/List;Lcom/discord/models/domain/ModelMemberVerificationForm;Ljava/util/Map;Ljava/util/Map;ZZZLcom/discord/models/guild/Guild;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class Loaded extends ViewState {
            private final boolean allowAnimatedEmojis;
            private final Map<Long, String> channelNames;
            private final boolean disabled;
            private final ModelMemberVerificationForm form;
            private final List<MemberVerificationItem> formItems;
            private final Guild guild;
            private final boolean isFormValid;
            private final boolean isRulesListVisible;
            private final boolean isTermsApproved;
            private final boolean needsAdditionalVerification;
            private final Map<Long, GuildRole> roles;
            private final boolean submitting;
            private final VerificationType verificationType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(boolean z2, boolean z3, boolean z4, VerificationType verificationType, boolean z5, List<? extends MemberVerificationItem> list, ModelMemberVerificationForm modelMemberVerificationForm, Map<Long, String> map, Map<Long, GuildRole> map2, boolean z6, boolean z7, boolean z8, Guild guild) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "formItems");
                Intrinsics3.checkNotNullParameter(map, "channelNames");
                Intrinsics3.checkNotNullParameter(map2, "roles");
                this.isRulesListVisible = z2;
                this.submitting = z3;
                this.disabled = z4;
                this.verificationType = verificationType;
                this.needsAdditionalVerification = z5;
                this.formItems = list;
                this.form = modelMemberVerificationForm;
                this.channelNames = map;
                this.roles = map2;
                this.allowAnimatedEmojis = z6;
                this.isFormValid = z7;
                this.isTermsApproved = z8;
                this.guild = guild;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, boolean z2, boolean z3, boolean z4, VerificationType verificationType, boolean z5, List list, ModelMemberVerificationForm modelMemberVerificationForm, Map map, Map map2, boolean z6, boolean z7, boolean z8, Guild guild, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.isRulesListVisible : z2, (i & 2) != 0 ? loaded.submitting : z3, (i & 4) != 0 ? loaded.disabled : z4, (i & 8) != 0 ? loaded.verificationType : verificationType, (i & 16) != 0 ? loaded.needsAdditionalVerification : z5, (i & 32) != 0 ? loaded.formItems : list, (i & 64) != 0 ? loaded.form : modelMemberVerificationForm, (i & 128) != 0 ? loaded.channelNames : map, (i & 256) != 0 ? loaded.roles : map2, (i & 512) != 0 ? loaded.allowAnimatedEmojis : z6, (i & 1024) != 0 ? loaded.isFormValid : z7, (i & 2048) != 0 ? loaded.isTermsApproved : z8, (i & 4096) != 0 ? loaded.guild : guild);
            }

            /* renamed from: component1, reason: from getter */
            public final boolean getIsRulesListVisible() {
                return this.isRulesListVisible;
            }

            /* renamed from: component10, reason: from getter */
            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            /* renamed from: component11, reason: from getter */
            public final boolean getIsFormValid() {
                return this.isFormValid;
            }

            /* renamed from: component12, reason: from getter */
            public final boolean getIsTermsApproved() {
                return this.isTermsApproved;
            }

            /* renamed from: component13, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* renamed from: component2, reason: from getter */
            public final boolean getSubmitting() {
                return this.submitting;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getDisabled() {
                return this.disabled;
            }

            /* renamed from: component4, reason: from getter */
            public final VerificationType getVerificationType() {
                return this.verificationType;
            }

            /* renamed from: component5, reason: from getter */
            public final boolean getNeedsAdditionalVerification() {
                return this.needsAdditionalVerification;
            }

            public final List<MemberVerificationItem> component6() {
                return this.formItems;
            }

            /* renamed from: component7, reason: from getter */
            public final ModelMemberVerificationForm getForm() {
                return this.form;
            }

            public final Map<Long, String> component8() {
                return this.channelNames;
            }

            public final Map<Long, GuildRole> component9() {
                return this.roles;
            }

            public final Loaded copy(boolean isRulesListVisible, boolean submitting, boolean disabled, VerificationType verificationType, boolean needsAdditionalVerification, List<? extends MemberVerificationItem> formItems, ModelMemberVerificationForm form, Map<Long, String> channelNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis, boolean isFormValid, boolean isTermsApproved, Guild guild) {
                Intrinsics3.checkNotNullParameter(formItems, "formItems");
                Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
                Intrinsics3.checkNotNullParameter(roles, "roles");
                return new Loaded(isRulesListVisible, submitting, disabled, verificationType, needsAdditionalVerification, formItems, form, channelNames, roles, allowAnimatedEmojis, isFormValid, isTermsApproved, guild);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return this.isRulesListVisible == loaded.isRulesListVisible && this.submitting == loaded.submitting && this.disabled == loaded.disabled && Intrinsics3.areEqual(this.verificationType, loaded.verificationType) && this.needsAdditionalVerification == loaded.needsAdditionalVerification && Intrinsics3.areEqual(this.formItems, loaded.formItems) && Intrinsics3.areEqual(this.form, loaded.form) && Intrinsics3.areEqual(this.channelNames, loaded.channelNames) && Intrinsics3.areEqual(this.roles, loaded.roles) && this.allowAnimatedEmojis == loaded.allowAnimatedEmojis && this.isFormValid == loaded.isFormValid && this.isTermsApproved == loaded.isTermsApproved && Intrinsics3.areEqual(this.guild, loaded.guild);
            }

            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            public final Map<Long, String> getChannelNames() {
                return this.channelNames;
            }

            public final boolean getDisabled() {
                return this.disabled;
            }

            public final ModelMemberVerificationForm getForm() {
                return this.form;
            }

            public final List<MemberVerificationItem> getFormItems() {
                return this.formItems;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final boolean getNeedsAdditionalVerification() {
                return this.needsAdditionalVerification;
            }

            public final Map<Long, GuildRole> getRoles() {
                return this.roles;
            }

            public final boolean getSubmitting() {
                return this.submitting;
            }

            public final VerificationType getVerificationType() {
                return this.verificationType;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v26 */
            /* JADX WARN: Type inference failed for: r0v27 */
            /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v21, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v23, types: [boolean] */
            /* JADX WARN: Type inference failed for: r2v7, types: [boolean] */
            public int hashCode() {
                boolean z2 = this.isRulesListVisible;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                ?? r2 = this.submitting;
                int i2 = r2;
                if (r2 != 0) {
                    i2 = 1;
                }
                int i3 = (i + i2) * 31;
                ?? r22 = this.disabled;
                int i4 = r22;
                if (r22 != 0) {
                    i4 = 1;
                }
                int i5 = (i3 + i4) * 31;
                VerificationType verificationType = this.verificationType;
                int iHashCode = (i5 + (verificationType != null ? verificationType.hashCode() : 0)) * 31;
                ?? r23 = this.needsAdditionalVerification;
                int i6 = r23;
                if (r23 != 0) {
                    i6 = 1;
                }
                int i7 = (iHashCode + i6) * 31;
                List<MemberVerificationItem> list = this.formItems;
                int iHashCode2 = (i7 + (list != null ? list.hashCode() : 0)) * 31;
                ModelMemberVerificationForm modelMemberVerificationForm = this.form;
                int iHashCode3 = (iHashCode2 + (modelMemberVerificationForm != null ? modelMemberVerificationForm.hashCode() : 0)) * 31;
                Map<Long, String> map = this.channelNames;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map2 = this.roles;
                int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
                ?? r24 = this.allowAnimatedEmojis;
                int i8 = r24;
                if (r24 != 0) {
                    i8 = 1;
                }
                int i9 = (iHashCode5 + i8) * 31;
                ?? r25 = this.isFormValid;
                int i10 = r25;
                if (r25 != 0) {
                    i10 = 1;
                }
                int i11 = (i9 + i10) * 31;
                boolean z3 = this.isTermsApproved;
                int i12 = (i11 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
                Guild guild = this.guild;
                return i12 + (guild != null ? guild.hashCode() : 0);
            }

            public final boolean isFormValid() {
                return this.isFormValid;
            }

            public final boolean isRulesListVisible() {
                return this.isRulesListVisible;
            }

            public final boolean isTermsApproved() {
                return this.isTermsApproved;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(isRulesListVisible=");
                sbU.append(this.isRulesListVisible);
                sbU.append(", submitting=");
                sbU.append(this.submitting);
                sbU.append(", disabled=");
                sbU.append(this.disabled);
                sbU.append(", verificationType=");
                sbU.append(this.verificationType);
                sbU.append(", needsAdditionalVerification=");
                sbU.append(this.needsAdditionalVerification);
                sbU.append(", formItems=");
                sbU.append(this.formItems);
                sbU.append(", form=");
                sbU.append(this.form);
                sbU.append(", channelNames=");
                sbU.append(this.channelNames);
                sbU.append(", roles=");
                sbU.append(this.roles);
                sbU.append(", allowAnimatedEmojis=");
                sbU.append(this.allowAnimatedEmojis);
                sbU.append(", isFormValid=");
                sbU.append(this.isFormValid);
                sbU.append(", isTermsApproved=");
                sbU.append(this.isTermsApproved);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: WidgetMemberVerificationViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState$Loading;", "Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            StoreGuildMemberVerificationForm.FetchStates.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreGuildMemberVerificationForm.FetchStates.FETCHING.ordinal()] = 1;
            iArr[StoreGuildMemberVerificationForm.FetchStates.SUCCEEDED.ordinal()] = 2;
            iArr[StoreGuildMemberVerificationForm.FetchStates.FAILED.ordinal()] = 3;
            ModelMemberVerificationForm.MemberVerificationFieldType.values();
            int[] iArr2 = new int[5];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ModelMemberVerificationForm.MemberVerificationFieldType.TERMS.ordinal()] = 1;
            iArr2[ModelMemberVerificationForm.MemberVerificationFieldType.TEXT_INPUT.ordinal()] = 2;
            iArr2[ModelMemberVerificationForm.MemberVerificationFieldType.PARAGRAPH.ordinal()] = 3;
            iArr2[ModelMemberVerificationForm.MemberVerificationFieldType.MULTIPLE_CHOICE.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetMemberVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/utilities/error/Error;", "it", "", "invoke", "(Lcom/discord/utilities/error/Error;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$applyToJoinGuild$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetMemberVerificationViewModel.access$handleGuildUpdateError(WidgetMemberVerificationViewModel.this);
        }
    }

    /* compiled from: WidgetMemberVerificationViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/models/domain/ModelMemberVerificationFormResponse;", "it", "", "invoke", "(Lcom/discord/models/domain/ModelMemberVerificationFormResponse;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$applyToJoinGuild$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<ModelMemberVerificationFormResponse, Unit> {
        public final /* synthetic */ ViewState.Loaded $currentViewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ViewState.Loaded loaded) {
            super(1);
            this.$currentViewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            invoke2(modelMemberVerificationFormResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
            Intrinsics3.checkNotNullParameter(modelMemberVerificationFormResponse, "it");
            WidgetMemberVerificationViewModel.access$updateViewState(WidgetMemberVerificationViewModel.this, ViewState.Loaded.copy$default(this.$currentViewState, false, false, false, null, false, null, null, null, null, false, false, false, null, 8189, null));
            PublishSubject publishSubjectAccess$getEventSubject$p = WidgetMemberVerificationViewModel.access$getEventSubject$p(WidgetMemberVerificationViewModel.this);
            Guild guild = this.$currentViewState.getGuild();
            Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
            Guild guild2 = this.$currentViewState.getGuild();
            publishSubjectAccess$getEventSubject$p.k.onNext(new Event.Success(lValueOf, guild2 != null ? guild2.getName() : null, modelMemberVerificationFormResponse.getApplicationStatus(), modelMemberVerificationFormResponse.getLastSeen()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetMemberVerificationViewModel(long j, String str, Guild guild, StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, RestAPI restAPI, Parser parser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Guild guild2 = (i & 4) != 0 ? null : guild;
        this(j, str, guild2, (i & 8) != 0 ? StoreStream.INSTANCE.getMemberVerificationForms() : storeGuildMemberVerificationForm, (i & 16) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, (i & 32) != 0 ? DiscordParser.createParser$default(false, true, false, false, false, 28, null) : parser, (i & 64) != 0 ? INSTANCE.observeStores(j, guild2) : observable);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel) {
        return widgetMemberVerificationViewModel.eventSubject;
    }

    public static final /* synthetic */ void access$handleGuildUpdateError(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel) {
        widgetMemberVerificationViewModel.handleGuildUpdateError();
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel, StoreState storeState) {
        widgetMemberVerificationViewModel.handleStoreState(storeState);
    }

    public static final /* synthetic */ void access$updateViewState(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel, ViewState viewState) {
        widgetMemberVerificationViewModel.updateViewState(viewState);
    }

    private final List<MemberVerificationItem> createFormItems(List<ModelMemberVerificationForm.FormField> formFields, boolean isTermsApproved, Map<Long, String> channelNames, Map<Long, GuildRole> roles, boolean allowAnimatedEmojis) {
        if (formFields == null || formFields.isEmpty()) {
            return Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (ModelMemberVerificationForm.FormField formField : formFields) {
            Object obj = this.formUserInputDataMap.get(Integer.valueOf(formFields.indexOf(formField)));
            int iOrdinal = formField.getMemberVerificationFieldType().ordinal();
            if (iOrdinal == 1) {
                List<String> values = formField.getValues();
                if (!values.isEmpty()) {
                    arrayList.add(new MemberVerificationItemTermsHeader());
                    int size = values.size();
                    int i = 0;
                    while (i < size) {
                        int i2 = i + 1;
                        arrayList.add(new MemberVerificationItemTerm(i2, values.get(i), generateAST(values.get(i)), channelNames, roles, allowAnimatedEmojis, i == 0, i == values.size() - 1));
                        i = i2;
                    }
                    arrayList.add(new MemberVerificationItemApproveTerms(formFields.indexOf(formField), isTermsApproved));
                }
            } else if (iOrdinal == 2) {
                arrayList.add(new MemberVerificationItemHeader(formField.getLabel()));
                arrayList.add(new MemberVerificationItemTextInput(formFields.indexOf(formField), (String) obj));
            } else if (iOrdinal == 3) {
                arrayList.add(new MemberVerificationItemHeader(formField.getLabel()));
                arrayList.add(new MemberVerificationItemParagraph(formFields.indexOf(formField), (String) obj));
            } else if (iOrdinal == 4) {
                arrayList.add(new MemberVerificationItemHeader(formField.getLabel()));
                arrayList.add(new MemberVerificationItemMultipleChoice(formFields.indexOf(formField), formField.getChoices(), (Integer) obj));
            }
        }
        return arrayList;
    }

    private final List<Node<MessageRenderContext>> generateAST(CharSequence rawRuleString) {
        return Parser.parse$default(this.rulesParser, rawRuleString, MessageParseState.INSTANCE.getInitialState(), null, 4, null);
    }

    @MainThread
    private final void handleGuildUpdateError() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, false, null, false, null, null, null, null, false, false, false, null, 8189, null));
            PublishSubject<Event> publishSubject = this.eventSubject;
            publishSubject.k.onNext(Event.Error.INSTANCE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
    
        if (com.discord.utilities.user.UserUtils.INSTANCE.getHasPhone(r0) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008a, code lost:
    
        if (com.discord.utilities.user.UserUtils.INSTANCE.getHasPhone(r0) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008c, code lost:
    
        r12 = r2;
        r13 = true;
     */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleStoreState(StoreState storeState) {
        VerificationType verificationType;
        VerificationType verificationType2;
        boolean z2;
        boolean z3;
        ModelMemberVerificationForm form;
        MeUser me2 = storeState.getMe();
        Guild guild = storeState.getGuild();
        StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData = storeState.getMemberVerificationFormData();
        Map<Long, String> channels = storeState.getChannels();
        Map<Long, GuildRole> roles = storeState.getRoles();
        boolean allowAnimatedEmojis = storeState.getAllowAnimatedEmojis();
        StoreGuildMemberVerificationForm.FetchStates fetchState = memberVerificationFormData != null ? memberVerificationFormData.getFetchState() : null;
        if (fetchState == null) {
            return;
        }
        int iOrdinal = fetchState.ordinal();
        if (iOrdinal == 0) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (iOrdinal == 1) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        if (iOrdinal != 2) {
            return;
        }
        ModelMemberVerificationForm form2 = memberVerificationFormData.getForm();
        List<ModelMemberVerificationForm.FormField> formFields = form2 != null ? form2.getFormFields() : null;
        GuildVerificationLevel verificationLevel = guild != null ? guild.getVerificationLevel() : null;
        GuildVerificationLevel guildVerificationLevel = GuildVerificationLevel.HIGHEST;
        boolean z4 = verificationLevel != guildVerificationLevel;
        boolean z5 = (guild != null ? guild.getVerificationLevel() : null) == guildVerificationLevel;
        boolean z6 = formFields == null || formFields.isEmpty();
        if (z4) {
            verificationType2 = VerificationType.EMAIL;
            if (!me2.isVerified()) {
            }
            verificationType = verificationType2;
            z2 = false;
        } else if (z5) {
            verificationType2 = VerificationType.PHONE;
        } else {
            verificationType = null;
            z2 = false;
        }
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        List<ModelMemberVerificationForm.FormField> formFields2 = (loaded == null || (form = loaded.getForm()) == null) ? null : form.getFormFields();
        if (formFields == null || !(!Intrinsics3.areEqual(formFields2, formFields))) {
            z3 = false;
        } else {
            this.formUserInputDataMap.clear();
            boolean z7 = false;
            int i = 0;
            for (Object obj : formFields) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                if (((ModelMemberVerificationForm.FormField) obj).getMemberVerificationFieldType() != ModelMemberVerificationForm.MemberVerificationFieldType.TERMS) {
                    this.formUserInputDataMap.put(Integer.valueOf(i), null);
                } else {
                    z7 = true;
                }
                i = i2;
            }
            z3 = z7;
        }
        updateViewState(new ViewState.Loaded((formFields == null || formFields.isEmpty()) ? false : true, false, !z6 || z2, verificationType, z2, createFormItems(formFields, !z3, channels, roles, allowAnimatedEmojis), memberVerificationFormData.getForm(), channels, roles, allowAnimatedEmojis, z6 && !z2, !z3, guild));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x003c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[LOOP:0: B:6:0x0013->B:28:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isFormValid() {
        boolean z2;
        Map<Integer, Object> map = this.formUserInputDataMap;
        boolean z3 = false;
        if (!map.isEmpty()) {
            Iterator<Map.Entry<Integer, Object>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object value = it.next().getValue();
                if (value == null) {
                    z2 = true;
                    if (z2) {
                        z3 = true;
                        break;
                    }
                } else {
                    if (value instanceof String) {
                        if (((CharSequence) value).length() == 0) {
                        }
                        if (z2) {
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                }
            }
        }
        return !z3;
    }

    public final void applyToJoinGuild() {
        List<ModelMemberVerificationForm.FormField> listEmptyList;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            updateViewState(ViewState.Loaded.copy$default(loaded, false, true, false, null, false, null, null, null, null, false, false, false, null, 8189, null));
            ModelMemberVerificationForm form = loaded.getForm();
            if (form == null || (listEmptyList = form.getFormFields()) == null) {
                listEmptyList = Collections2.emptyList();
            }
            for (Map.Entry<Integer, Object> entry : this.formUserInputDataMap.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                Object value = entry.getValue();
                if (value != null) {
                    listEmptyList.get(iIntValue).setResponse(value);
                }
            }
            int i = 0;
            for (Object obj : listEmptyList) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                if (((ModelMemberVerificationForm.FormField) obj).getMemberVerificationFieldType() == ModelMemberVerificationForm.MemberVerificationFieldType.TERMS) {
                    listEmptyList.get(i).setResponse(Boolean.valueOf(loaded.isTermsApproved()));
                }
                i = i2;
            }
            RestAPI restAPI = this.restAPI;
            long j = this.guildId;
            ModelMemberVerificationForm form2 = loaded.getForm();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(restAPI.createGuildJoinRequest(j, new RestAPIParams.MemberVerificationForm(listEmptyList, form2 != null ? form2.getVersion() : null)), false, 1, null), this, null, 2, null), WidgetMemberVerificationViewModel.class, (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass4(loaded), 54, (Object) null);
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @Override // b.a.d.AppViewModel, androidx.view.ViewModel
    public void onCleared() {
        super.onCleared();
        AnalyticsTracker.INSTANCE.dismissModal("Membership Gating", this.location, "dismissed", Long.valueOf(this.guildId));
    }

    public final void updateFormValidation(int key, Object value) {
        boolean zIsFormValid;
        this.formUserInputDataMap.put(Integer.valueOf(key), value);
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || loaded.isFormValid() == (zIsFormValid = isFormValid())) {
            return;
        }
        boolean zIsTermsApproved = loaded.isTermsApproved();
        ModelMemberVerificationForm form = loaded.getForm();
        updateViewState(ViewState.Loaded.copy$default(loaded, false, false, (zIsFormValid && zIsTermsApproved && !loaded.getNeedsAdditionalVerification()) ? false : true, null, false, createFormItems(form != null ? form.getFormFields() : null, zIsTermsApproved, loaded.getChannelNames(), loaded.getRoles(), loaded.getAllowAnimatedEmojis()), null, null, null, false, zIsFormValid, false, null, 7131, null));
    }

    public final void updateTermsApproval(boolean isTermsApproved) {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded != null) {
            boolean zIsFormValid = isFormValid();
            ModelMemberVerificationForm form = loaded.getForm();
            updateViewState(ViewState.Loaded.copy$default(loaded, false, false, (zIsFormValid && isTermsApproved && !loaded.getNeedsAdditionalVerification()) ? false : true, null, false, createFormItems(form != null ? form.getFormFields() : null, isTermsApproved, loaded.getChannelNames(), loaded.getRoles(), loaded.getAllowAnimatedEmojis()), null, null, null, false, zIsFormValid, isTermsApproved, null, 5083, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerificationViewModel(long j, String str, Guild guild, StoreGuildMemberVerificationForm storeGuildMemberVerificationForm, RestAPI restAPI, Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(storeGuildMemberVerificationForm, "storeGuildMemberVerificationForm");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(parser, "rulesParser");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.location = str;
        this.inviteGuild = guild;
        this.restAPI = restAPI;
        this.rulesParser = parser;
        this.eventSubject = PublishSubject.k0();
        this.formUserInputDataMap = new HashMap();
        AnalyticsTracker.openModal("Membership Gating", str, Long.valueOf(j));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), WidgetMemberVerificationViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        storeGuildMemberVerificationForm.fetchMemberVerificationForm(j);
    }
}
