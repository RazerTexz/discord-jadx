package com.discord.widgets.chat.input.expression;

import android.content.Context;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.sticker.Sticker;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExpressionPickerNavigation;
import com.discord.stores.StoreGuildStickers;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.input.expression.ExpressionDetailPage;
import com.discord.widgets.chat.input.expression.ExpressionPickerEvent;
import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: ExpressionTrayViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 O2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004OPQRBc\u0012\b\b\u0002\u0010I\u001a\u00020H\u0012\b\b\u0002\u00106\u001a\u000205\u0012\b\b\u0002\u00109\u001a\u000208\u0012\b\b\u0002\u0010@\u001a\u00020?\u0012\b\b\u0002\u0010C\u001a\u00020B\u0012\b\b\u0002\u0010F\u001a\u00020E\u0012\u000e\b\u0002\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f\u0012\u000e\b\u0002\u0010L\u001a\b\u0012\u0004\u0012\u00020\b0\u001f¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\rJ-\u0010\u0014\u001a\u00020\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0016\u001a\u00020\u00052\u0010\b\u0002\u0010\u0011\u001a\n\u0018\u00010\u000fj\u0004\u0018\u0001`\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\rJ\u0017\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b&\u0010'J\r\u0010(\u001a\u00020\u0005¢\u0006\u0004\b(\u0010\rJ\u0015\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\u00020\u00052\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\u00052\u0006\u00101\u001a\u00020-¢\u0006\u0004\b2\u00100R\u0016\u00103\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00109\u001a\u0002088\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010:R:\u0010=\u001a&\u0012\f\u0012\n <*\u0004\u0018\u00010 0  <*\u0012\u0012\f\u0012\n <*\u0004\u0018\u00010 0 \u0018\u00010;0;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006S"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;", "storeState", "", "handleStoreState", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;)V", "Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;", "expressionPickerEvent", "handleExpressionPickerEvents", "(Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;)V", "showEmojiPickerSheet", "()V", "showGifPickerSheet", "", "Lcom/discord/primitives/StickerPackId;", "stickerPackId", "", "searchText", "showStickerPickerSheet", "(Ljava/lang/Long;Ljava/lang/String;)V", "showStickerPickerInline", "hideExpressionPicker", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "expressionTab", "getChatInputComponentType", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;)Ljava/lang/String;", "viewState", "updateViewState", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;)V", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;", "observeEvents", "()Lrx/Observable;", "expressionTrayTab", "selectTab", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;)V", "clickSearch", "(Ljava/lang/String;)V", "clickBack", "Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;", "gifCategoryItem", "selectGifCategory", "(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;)V", "", "show", "showStickersSearchBar", "(Z)V", "isActive", "handleIsActive", "wasActive", "Z", "Lcom/discord/stores/StoreExpressionPickerNavigation;", "storeExpressionPickerNavigation", "Lcom/discord/stores/StoreExpressionPickerNavigation;", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreChannelsSelected;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreUser;", "Lcom/discord/stores/StoreGuildStickers;", "storeGuildStickers", "Lcom/discord/stores/StoreGuildStickers;", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lcom/discord/stores/StoreGuilds;", "Lcom/discord/stores/StoreAnalytics;", "storeAnalytics", "Lcom/discord/stores/StoreAnalytics;", "storeStateObservable", "expressionPickerNavigationObservable", "<init>", "(Lcom/discord/stores/StoreAnalytics;Lcom/discord/stores/StoreExpressionPickerNavigation;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuildStickers;Lcom/discord/stores/StoreGuilds;Lrx/Observable;Lrx/Observable;)V", "Companion", "Event", "StoreState", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ExpressionTrayViewModel extends AppViewModel<ViewState> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final StoreAnalytics storeAnalytics;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreExpressionPickerNavigation storeExpressionPickerNavigation;
    private final StoreGuildStickers storeGuildStickers;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;
    private boolean wasActive;

    /* compiled from: ExpressionTrayViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.ExpressionTrayViewModel$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(ExpressionTrayViewModel expressionTrayViewModel) {
            super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ExpressionTrayViewModel.access$handleStoreState((ExpressionTrayViewModel) this.receiver, storeState);
        }
    }

    /* compiled from: ExpressionTrayViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;", "p1", "", "invoke", "(Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.chat.input.expression.ExpressionTrayViewModel$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ExpressionPickerEvent, Unit> {
        public AnonymousClass2(ExpressionTrayViewModel expressionTrayViewModel) {
            super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "handleExpressionPickerEvents", "handleExpressionPickerEvents(Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ExpressionPickerEvent expressionPickerEvent) {
            invoke2(expressionPickerEvent);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ExpressionPickerEvent expressionPickerEvent) {
            Intrinsics3.checkNotNullParameter(expressionPickerEvent, "p1");
            ExpressionTrayViewModel.access$handleExpressionPickerEvents((ExpressionTrayViewModel) this.receiver, expressionPickerEvent);
        }
    }

    /* compiled from: ExpressionTrayViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J=\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Companion;", "", "Lcom/discord/stores/StoreExpressionPickerNavigation;", "storeExpressionPickerNavigation", "Lcom/discord/stores/StoreChannelsSelected;", "storeChannelsSelected", "Lcom/discord/stores/StoreUser;", "storeUser", "Lcom/discord/stores/StoreGuildStickers;", "storeGuildStickers", "Lcom/discord/stores/StoreGuilds;", "storeGuilds", "Lrx/Observable;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;", "observeStoreState", "(Lcom/discord/stores/StoreExpressionPickerNavigation;Lcom/discord/stores/StoreChannelsSelected;Lcom/discord/stores/StoreUser;Lcom/discord/stores/StoreGuildStickers;Lcom/discord/stores/StoreGuilds;)Lrx/Observable;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ Observable access$observeStoreState(Companion companion, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds) {
            return companion.observeStoreState(storeExpressionPickerNavigation, storeChannelsSelected, storeUser, storeGuildStickers, storeGuilds);
        }

        private final Observable<StoreState> observeStoreState(StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds) {
            Observable<StoreState> observableG = Observable.g(storeExpressionPickerNavigation.observeSelectedTab(), storeChannelsSelected.observeResolvedSelectedChannel(), StoreUser.observeMe$default(storeUser, false, 1, null), storeGuildStickers.observeGuildStickers(), storeGuilds.observeGuilds(), ExpressionTrayViewModel2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…aft\n          )\n        }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ExpressionTrayViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;", "", "<init>", "()V", "HideExpressionTray", "ShowEmojiPickerSheet", "ShowGifPickerSheet", "ShowStickerPicker", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event$HideExpressionTray;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event$ShowEmojiPickerSheet;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event$ShowGifPickerSheet;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event$ShowStickerPicker;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: ExpressionTrayViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event$HideExpressionTray;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class HideExpressionTray extends Event {
            public static final HideExpressionTray INSTANCE = new HideExpressionTray();

            private HideExpressionTray() {
                super(null);
            }
        }

        /* compiled from: ExpressionTrayViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event$ShowEmojiPickerSheet;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowEmojiPickerSheet extends Event {
            public static final ShowEmojiPickerSheet INSTANCE = new ShowEmojiPickerSheet();

            private ShowEmojiPickerSheet() {
                super(null);
            }
        }

        /* compiled from: ExpressionTrayViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event$ShowGifPickerSheet;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class ShowGifPickerSheet extends Event {
            public static final ShowGifPickerSheet INSTANCE = new ShowGifPickerSheet();

            private ShowGifPickerSheet() {
                super(null);
            }
        }

        /* compiled from: ExpressionTrayViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R!\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\b¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event$ShowStickerPicker;", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event;", "", "Lcom/discord/primitives/StickerPackId;", "component1", "()Ljava/lang/Long;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "stickerPackId", "searchText", "inline", "copy", "(Ljava/lang/Long;Ljava/lang/String;Z)Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$Event$ShowStickerPicker;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getStickerPackId", "Z", "getInline", "Ljava/lang/String;", "getSearchText", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowStickerPicker extends Event {
            private final boolean inline;
            private final String searchText;
            private final Long stickerPackId;

            public /* synthetic */ ShowStickerPicker(Long l, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(l, str, (i & 4) != 0 ? false : z2);
            }

            public static /* synthetic */ ShowStickerPicker copy$default(ShowStickerPicker showStickerPicker, Long l, String str, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    l = showStickerPicker.stickerPackId;
                }
                if ((i & 2) != 0) {
                    str = showStickerPicker.searchText;
                }
                if ((i & 4) != 0) {
                    z2 = showStickerPicker.inline;
                }
                return showStickerPicker.copy(l, str, z2);
            }

            /* renamed from: component1, reason: from getter */
            public final Long getStickerPackId() {
                return this.stickerPackId;
            }

            /* renamed from: component2, reason: from getter */
            public final String getSearchText() {
                return this.searchText;
            }

            /* renamed from: component3, reason: from getter */
            public final boolean getInline() {
                return this.inline;
            }

            public final ShowStickerPicker copy(Long stickerPackId, String searchText, boolean inline) {
                return new ShowStickerPicker(stickerPackId, searchText, inline);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowStickerPicker)) {
                    return false;
                }
                ShowStickerPicker showStickerPicker = (ShowStickerPicker) other;
                return Intrinsics3.areEqual(this.stickerPackId, showStickerPicker.stickerPackId) && Intrinsics3.areEqual(this.searchText, showStickerPicker.searchText) && this.inline == showStickerPicker.inline;
            }

            public final boolean getInline() {
                return this.inline;
            }

            public final String getSearchText() {
                return this.searchText;
            }

            public final Long getStickerPackId() {
                return this.stickerPackId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public int hashCode() {
                Long l = this.stickerPackId;
                int iHashCode = (l != null ? l.hashCode() : 0) * 31;
                String str = this.searchText;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                boolean z2 = this.inline;
                int i = z2;
                if (z2 != 0) {
                    i = 1;
                }
                return iHashCode2 + i;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ShowStickerPicker(stickerPackId=");
                sbU.append(this.stickerPackId);
                sbU.append(", searchText=");
                sbU.append(this.searchText);
                sbU.append(", inline=");
                return outline.O(sbU, this.inline, ")");
            }

            public ShowStickerPicker(Long l, String str, boolean z2) {
                super(null);
                this.stickerPackId = l;
                this.searchText = str;
                this.inline = z2;
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: ExpressionTrayViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012&\u0010\u001a\u001a\"\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u00020\u000e0\f0\f\u0012\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b3\u00104J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ0\u0010\u000f\u001a\"\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u00020\u000e0\f0\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0080\u0001\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u00022\u0010\b\u0002\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2(\b\u0002\u0010\u001a\u001a\"\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u00020\u000e0\f0\f2\u0012\b\u0002\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u0014HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010#\u001a\u00020\"HÖ\u0001¢\u0006\u0004\b#\u0010$J\u001a\u0010&\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b)\u0010\u000bR\u0019\u0010\u001c\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010*\u001a\u0004\b\u001c\u0010\u0016R9\u0010\u001a\u001a\"\u0012\b\u0012\u00060\u0005j\u0002`\u0006\u0012\u0014\u0012\u0012\u0012\b\u0012\u00060\u0005j\u0002`\r\u0012\u0004\u0012\u00020\u000e0\f0\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b,\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010-\u001a\u0004\b.\u0010\u0004R#\u0010\u001b\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010/\u001a\u0004\b0\u0010\u0013R!\u0010\u0018\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b2\u0010\b¨\u00065"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;", "", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "component1", "()Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "", "Lcom/discord/primitives/GuildId;", "component2", "()Ljava/lang/Long;", "Lcom/discord/models/user/MeUser;", "component3", "()Lcom/discord/models/user/MeUser;", "", "Lcom/discord/primitives/StickerId;", "Lcom/discord/api/sticker/Sticker;", "component4", "()Ljava/util/Map;", "", "component5", "()Ljava/util/Set;", "", "component6", "()Z", "selectedExpressionTab", "guildId", "meUser", "guildStickers", "userGuildIds", "isThreadDraft", "copy", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;Ljava/lang/Long;Lcom/discord/models/user/MeUser;Ljava/util/Map;Ljava/util/Set;Z)Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$StoreState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/user/MeUser;", "getMeUser", "Z", "Ljava/util/Map;", "getGuildStickers", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "getSelectedExpressionTab", "Ljava/util/Set;", "getUserGuildIds", "Ljava/lang/Long;", "getGuildId", "<init>", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;Ljava/lang/Long;Lcom/discord/models/user/MeUser;Ljava/util/Map;Ljava/util/Set;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class StoreState {
        private final Long guildId;
        private final Map<Long, Map<Long, Sticker>> guildStickers;
        private final boolean isThreadDraft;
        private final MeUser meUser;
        private final ExpressionTrayTab selectedExpressionTab;
        private final Set<Long> userGuildIds;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(ExpressionTrayTab expressionTrayTab, Long l, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> map, Set<Long> set, boolean z2) {
            Intrinsics3.checkNotNullParameter(expressionTrayTab, "selectedExpressionTab");
            Intrinsics3.checkNotNullParameter(map, "guildStickers");
            Intrinsics3.checkNotNullParameter(set, "userGuildIds");
            this.selectedExpressionTab = expressionTrayTab;
            this.guildId = l;
            this.meUser = meUser;
            this.guildStickers = map;
            this.userGuildIds = set;
            this.isThreadDraft = z2;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, ExpressionTrayTab expressionTrayTab, Long l, MeUser meUser, Map map, Set set, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                expressionTrayTab = storeState.selectedExpressionTab;
            }
            if ((i & 2) != 0) {
                l = storeState.guildId;
            }
            Long l2 = l;
            if ((i & 4) != 0) {
                meUser = storeState.meUser;
            }
            MeUser meUser2 = meUser;
            if ((i & 8) != 0) {
                map = storeState.guildStickers;
            }
            Map map2 = map;
            if ((i & 16) != 0) {
                set = storeState.userGuildIds;
            }
            Set set2 = set;
            if ((i & 32) != 0) {
                z2 = storeState.isThreadDraft;
            }
            return storeState.copy(expressionTrayTab, l2, meUser2, map2, set2, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final ExpressionTrayTab getSelectedExpressionTab() {
            return this.selectedExpressionTab;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component3, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Map<Long, Map<Long, Sticker>> component4() {
            return this.guildStickers;
        }

        public final Set<Long> component5() {
            return this.userGuildIds;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIsThreadDraft() {
            return this.isThreadDraft;
        }

        public final StoreState copy(ExpressionTrayTab selectedExpressionTab, Long guildId, MeUser meUser, Map<Long, ? extends Map<Long, Sticker>> guildStickers, Set<Long> userGuildIds, boolean isThreadDraft) {
            Intrinsics3.checkNotNullParameter(selectedExpressionTab, "selectedExpressionTab");
            Intrinsics3.checkNotNullParameter(guildStickers, "guildStickers");
            Intrinsics3.checkNotNullParameter(userGuildIds, "userGuildIds");
            return new StoreState(selectedExpressionTab, guildId, meUser, guildStickers, userGuildIds, isThreadDraft);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.selectedExpressionTab, storeState.selectedExpressionTab) && Intrinsics3.areEqual(this.guildId, storeState.guildId) && Intrinsics3.areEqual(this.meUser, storeState.meUser) && Intrinsics3.areEqual(this.guildStickers, storeState.guildStickers) && Intrinsics3.areEqual(this.userGuildIds, storeState.userGuildIds) && this.isThreadDraft == storeState.isThreadDraft;
        }

        public final Long getGuildId() {
            return this.guildId;
        }

        public final Map<Long, Map<Long, Sticker>> getGuildStickers() {
            return this.guildStickers;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final ExpressionTrayTab getSelectedExpressionTab() {
            return this.selectedExpressionTab;
        }

        public final Set<Long> getUserGuildIds() {
            return this.userGuildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ExpressionTrayTab expressionTrayTab = this.selectedExpressionTab;
            int iHashCode = (expressionTrayTab != null ? expressionTrayTab.hashCode() : 0) * 31;
            Long l = this.guildId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            MeUser meUser = this.meUser;
            int iHashCode3 = (iHashCode2 + (meUser != null ? meUser.hashCode() : 0)) * 31;
            Map<Long, Map<Long, Sticker>> map = this.guildStickers;
            int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
            Set<Long> set = this.userGuildIds;
            int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
            boolean z2 = this.isThreadDraft;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode5 + i;
        }

        public final boolean isThreadDraft() {
            return this.isThreadDraft;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(selectedExpressionTab=");
            sbU.append(this.selectedExpressionTab);
            sbU.append(", guildId=");
            sbU.append(this.guildId);
            sbU.append(", meUser=");
            sbU.append(this.meUser);
            sbU.append(", guildStickers=");
            sbU.append(this.guildStickers);
            sbU.append(", userGuildIds=");
            sbU.append(this.userGuildIds);
            sbU.append(", isThreadDraft=");
            return outline.O(sbU, this.isThreadDraft, ")");
        }

        public /* synthetic */ StoreState(ExpressionTrayTab expressionTrayTab, Long l, MeUser meUser, Map map, Set set, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(expressionTrayTab, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : meUser, map, set, z2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ExpressionTrayTab.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            ExpressionTrayTab expressionTrayTab = ExpressionTrayTab.EMOJI;
            iArr[expressionTrayTab.ordinal()] = 1;
            ExpressionTrayTab expressionTrayTab2 = ExpressionTrayTab.GIF;
            iArr[expressionTrayTab2.ordinal()] = 2;
            ExpressionTrayTab expressionTrayTab3 = ExpressionTrayTab.STICKER;
            iArr[expressionTrayTab3.ordinal()] = 3;
            ExpressionTrayTab.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[expressionTrayTab.ordinal()] = 1;
            iArr2[expressionTrayTab2.ordinal()] = 2;
            iArr2[expressionTrayTab3.ordinal()] = 3;
        }
    }

    public ExpressionTrayViewModel() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ExpressionTrayViewModel(StoreAnalytics storeAnalytics, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds, Observable observable, Observable observable2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreAnalytics analytics = (i & 1) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreExpressionPickerNavigation expressionPickerNavigation = (i & 2) != 0 ? StoreStream.INSTANCE.getExpressionPickerNavigation() : storeExpressionPickerNavigation;
        StoreChannelsSelected channelsSelected = (i & 4) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreUser users = (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuildStickers guildStickers = (i & 16) != 0 ? StoreStream.INSTANCE.getGuildStickers() : storeGuildStickers;
        StoreGuilds guilds = (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(analytics, expressionPickerNavigation, channelsSelected, users, guildStickers, guilds, (i & 64) != 0 ? Companion.access$observeStoreState(INSTANCE, expressionPickerNavigation, channelsSelected, users, guildStickers, guilds) : observable, (i & 128) != 0 ? ExpressionPickerEventBus.INSTANCE.getINSTANCE().observeExpressionPickerEvents() : observable2);
    }

    public static final /* synthetic */ void access$handleExpressionPickerEvents(ExpressionTrayViewModel expressionTrayViewModel, ExpressionPickerEvent expressionPickerEvent) {
        expressionTrayViewModel.handleExpressionPickerEvents(expressionPickerEvent);
    }

    public static final /* synthetic */ void access$handleStoreState(ExpressionTrayViewModel expressionTrayViewModel, StoreState storeState) {
        expressionTrayViewModel.handleStoreState(storeState);
    }

    public static /* synthetic */ void clickSearch$default(ExpressionTrayViewModel expressionTrayViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        expressionTrayViewModel.clickSearch(str);
    }

    private final String getChatInputComponentType(ExpressionTrayTab expressionTab) {
        int iOrdinal = expressionTab.ordinal();
        if (iOrdinal == 0) {
            return "emoji";
        }
        if (iOrdinal == 1) {
            return "GIF";
        }
        if (iOrdinal == 2) {
            return "sticker";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleExpressionPickerEvents(ExpressionPickerEvent expressionPickerEvent) {
        if (Intrinsics3.areEqual(expressionPickerEvent, ExpressionPickerEvent.CloseExpressionPicker.INSTANCE)) {
            hideExpressionPicker();
            return;
        }
        if (expressionPickerEvent instanceof ExpressionPickerEvent.OpenStickerPicker) {
            ExpressionPickerEvent.OpenStickerPicker openStickerPicker = (ExpressionPickerEvent.OpenStickerPicker) expressionPickerEvent;
            if (!openStickerPicker.getInline()) {
                showStickerPickerSheet(openStickerPicker.getStickerPackId(), openStickerPicker.getSearchText());
            }
            Long stickerPackId = openStickerPicker.getStickerPackId();
            long jLongValue = stickerPackId != null ? stickerPackId.longValue() : -1L;
            selectTab(ExpressionTrayTab.STICKER);
            showStickerPickerInline(Long.valueOf(jLongValue), openStickerPicker.getSearchText());
        }
    }

    private final void handleStoreState(StoreState storeState) {
        updateViewState2(ViewState.copy$default(requireViewState(), storeState.getSelectedExpressionTab(), null, false, !storeState.isThreadDraft(), 6, null));
    }

    private final void hideExpressionPicker() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.HideExpressionTray.INSTANCE);
    }

    private final void showEmojiPickerSheet() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowEmojiPickerSheet.INSTANCE);
    }

    private final void showGifPickerSheet() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.ShowGifPickerSheet.INSTANCE);
    }

    private final void showStickerPickerInline(Long stickerPackId, String searchText) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowStickerPicker(stickerPackId, searchText, true));
    }

    public static /* synthetic */ void showStickerPickerInline$default(ExpressionTrayViewModel expressionTrayViewModel, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        expressionTrayViewModel.showStickerPickerInline(l, str);
    }

    private final void showStickerPickerSheet(Long stickerPackId, String searchText) {
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowStickerPicker(stickerPackId, searchText, false, 4, null));
    }

    public static /* synthetic */ void showStickerPickerSheet$default(ExpressionTrayViewModel expressionTrayViewModel, Long l, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        expressionTrayViewModel.showStickerPickerSheet(l, str);
    }

    public final void clickBack() {
        ViewState viewStateRequireViewState = requireViewState();
        if (viewStateRequireViewState.getExpressionDetailPage() != null) {
            updateViewState2(ViewState.copy$default(viewStateRequireViewState, null, null, false, false, 13, null));
        }
    }

    public final void clickSearch(String searchText) {
        int iOrdinal = requireViewState().getSelectedExpressionTab().ordinal();
        if (iOrdinal == 0) {
            showEmojiPickerSheet();
        } else if (iOrdinal == 1) {
            showGifPickerSheet();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            showStickerPickerSheet$default(this, null, searchText, 1, null);
        }
    }

    public final void handleIsActive(boolean isActive) {
        ViewState viewState;
        ExpressionTrayTab selectedExpressionTab;
        if (isActive && !this.wasActive && (viewState = getViewState()) != null && (selectedExpressionTab = viewState.getSelectedExpressionTab()) != null) {
            this.storeAnalytics.trackChatInputComponentViewed(getChatInputComponentType(selectedExpressionTab));
        }
        this.wasActive = isActive;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void selectGifCategory(GifCategoryItem gifCategoryItem) {
        Intrinsics3.checkNotNullParameter(gifCategoryItem, "gifCategoryItem");
        updateViewState2(ViewState.copy$default(requireViewState(), null, new ExpressionDetailPage.GifCategoryPage(gifCategoryItem), false, false, 13, null));
    }

    public final void selectTab(ExpressionTrayTab expressionTrayTab) {
        Intrinsics3.checkNotNullParameter(expressionTrayTab, "expressionTrayTab");
        this.storeExpressionPickerNavigation.onSelectTab(expressionTrayTab);
    }

    public final void showStickersSearchBar(boolean show) {
        updateViewState2(ViewState.copy$default(requireViewState(), null, null, show, false, 11, null));
    }

    @Override // b.a.d.AppViewModel
    public /* bridge */ /* synthetic */ void updateViewState(ViewState viewState) {
        updateViewState2(viewState);
    }

    /* renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        ViewState viewState2 = getViewState();
        ExpressionTrayTab selectedExpressionTab = viewState2 != null ? viewState2.getSelectedExpressionTab() : null;
        ExpressionTrayTab selectedExpressionTab2 = viewState.getSelectedExpressionTab();
        if (viewState.getShowLandingPage() && selectedExpressionTab != selectedExpressionTab2 && this.wasActive) {
            this.storeAnalytics.trackChatInputComponentViewed(getChatInputComponentType(selectedExpressionTab2));
        }
        super.updateViewState((ExpressionTrayViewModel) viewState);
    }

    /* compiled from: ExpressionTrayViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u000b\u0010\nJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u001b\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u0019\u0010\u000e\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\nR\u0019\u0010\u000f\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\nR\u0019\u0010\"\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010\nR\u0019\u0010$\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010\n¨\u0006("}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;", "", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "component1", "()Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage;", "component2", "()Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage;", "", "component3", "()Z", "component4", "selectedExpressionTab", "expressionDetailPage", "showStickersSearchBar", "showGifsAndStickers", "copy", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage;ZZ)Lcom/discord/widgets/chat/input/expression/ExpressionTrayViewModel$ViewState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage;", "getExpressionDetailPage", "Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;", "getSelectedExpressionTab", "Z", "getShowStickersSearchBar", "getShowGifsAndStickers", "showLandingPage", "getShowLandingPage", "showSearchBar", "getShowSearchBar", "<init>", "(Lcom/discord/widgets/chat/input/expression/ExpressionTrayTab;Lcom/discord/widgets/chat/input/expression/ExpressionDetailPage;ZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ViewState {
        private final ExpressionDetailPage expressionDetailPage;
        private final ExpressionTrayTab selectedExpressionTab;
        private final boolean showGifsAndStickers;
        private final boolean showLandingPage;
        private final boolean showSearchBar;
        private final boolean showStickersSearchBar;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                ExpressionTrayTab.values();
                int[] iArr = new int[3];
                $EnumSwitchMapping$0 = iArr;
                iArr[ExpressionTrayTab.EMOJI.ordinal()] = 1;
                iArr[ExpressionTrayTab.GIF.ordinal()] = 2;
                iArr[ExpressionTrayTab.STICKER.ordinal()] = 3;
            }
        }

        public ViewState(ExpressionTrayTab expressionTrayTab, ExpressionDetailPage expressionDetailPage, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(expressionTrayTab, "selectedExpressionTab");
            this.selectedExpressionTab = expressionTrayTab;
            this.expressionDetailPage = expressionDetailPage;
            this.showStickersSearchBar = z2;
            this.showGifsAndStickers = z3;
            this.showLandingPage = expressionDetailPage == null;
            int iOrdinal = expressionTrayTab.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                z2 = true;
            } else if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            this.showSearchBar = z2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, ExpressionTrayTab expressionTrayTab, ExpressionDetailPage expressionDetailPage, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                expressionTrayTab = viewState.selectedExpressionTab;
            }
            if ((i & 2) != 0) {
                expressionDetailPage = viewState.expressionDetailPage;
            }
            if ((i & 4) != 0) {
                z2 = viewState.showStickersSearchBar;
            }
            if ((i & 8) != 0) {
                z3 = viewState.showGifsAndStickers;
            }
            return viewState.copy(expressionTrayTab, expressionDetailPage, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final ExpressionTrayTab getSelectedExpressionTab() {
            return this.selectedExpressionTab;
        }

        /* renamed from: component2, reason: from getter */
        public final ExpressionDetailPage getExpressionDetailPage() {
            return this.expressionDetailPage;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getShowStickersSearchBar() {
            return this.showStickersSearchBar;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getShowGifsAndStickers() {
            return this.showGifsAndStickers;
        }

        public final ViewState copy(ExpressionTrayTab selectedExpressionTab, ExpressionDetailPage expressionDetailPage, boolean showStickersSearchBar, boolean showGifsAndStickers) {
            Intrinsics3.checkNotNullParameter(selectedExpressionTab, "selectedExpressionTab");
            return new ViewState(selectedExpressionTab, expressionDetailPage, showStickersSearchBar, showGifsAndStickers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.selectedExpressionTab, viewState.selectedExpressionTab) && Intrinsics3.areEqual(this.expressionDetailPage, viewState.expressionDetailPage) && this.showStickersSearchBar == viewState.showStickersSearchBar && this.showGifsAndStickers == viewState.showGifsAndStickers;
        }

        public final ExpressionDetailPage getExpressionDetailPage() {
            return this.expressionDetailPage;
        }

        public final ExpressionTrayTab getSelectedExpressionTab() {
            return this.selectedExpressionTab;
        }

        public final boolean getShowGifsAndStickers() {
            return this.showGifsAndStickers;
        }

        public final boolean getShowLandingPage() {
            return this.showLandingPage;
        }

        public final boolean getShowSearchBar() {
            return this.showSearchBar;
        }

        public final boolean getShowStickersSearchBar() {
            return this.showStickersSearchBar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            ExpressionTrayTab expressionTrayTab = this.selectedExpressionTab;
            int iHashCode = (expressionTrayTab != null ? expressionTrayTab.hashCode() : 0) * 31;
            ExpressionDetailPage expressionDetailPage = this.expressionDetailPage;
            int iHashCode2 = (iHashCode + (expressionDetailPage != null ? expressionDetailPage.hashCode() : 0)) * 31;
            boolean z2 = this.showStickersSearchBar;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.showGifsAndStickers;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(selectedExpressionTab=");
            sbU.append(this.selectedExpressionTab);
            sbU.append(", expressionDetailPage=");
            sbU.append(this.expressionDetailPage);
            sbU.append(", showStickersSearchBar=");
            sbU.append(this.showStickersSearchBar);
            sbU.append(", showGifsAndStickers=");
            return outline.O(sbU, this.showGifsAndStickers, ")");
        }

        public /* synthetic */ ViewState(ExpressionTrayTab expressionTrayTab, ExpressionDetailPage expressionDetailPage, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(expressionTrayTab, (i & 2) != 0 ? null : expressionDetailPage, z2, z3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpressionTrayViewModel(StoreAnalytics storeAnalytics, StoreExpressionPickerNavigation storeExpressionPickerNavigation, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreGuildStickers storeGuildStickers, StoreGuilds storeGuilds, Observable<StoreState> observable, Observable<ExpressionPickerEvent> observable2) {
        super(new ViewState(ExpressionTrayTab.EMOJI, null, true, true, 2, null));
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeExpressionPickerNavigation, "storeExpressionPickerNavigation");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(storeGuildStickers, "storeGuildStickers");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(observable2, "expressionPickerNavigationObservable");
        this.storeAnalytics = storeAnalytics;
        this.storeExpressionPickerNavigation = storeExpressionPickerNavigation;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeUser = storeUser;
        this.storeGuildStickers = storeGuildStickers;
        this.storeGuilds = storeGuilds;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), ExpressionTrayViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable2, this, null, 2, null), ExpressionTrayViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
