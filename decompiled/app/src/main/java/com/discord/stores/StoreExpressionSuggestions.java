package com.discord.stores;

import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreExpressionSuggestions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 $2\u00020\u0001:\u0001$B!\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\"\u0010#J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/discord/stores/StoreExpressionSuggestions;", "Lcom/discord/stores/StoreV2;", "Lrx/Observable;", "", "observeSuggestionsEnabled", "()Lrx/Observable;", "enable", "", "setExpressionSuggestionsEnabled", "(Z)V", "handleChannelSelected", "()V", "", "suggestionTrigger", "trackExpressionSuggestionsDisplayed", "(Ljava/lang/String;)V", "getLastSuggestionTrigger", "()Ljava/lang/String;", "Lcom/discord/utilities/time/Clock;", "clock", "Lcom/discord/utilities/time/Clock;", "", "lastTrackedExpressionSuggestionsDisplayed", "J", "suggestionsEnabled", "Z", "lastSuggestionTrigger", "Ljava/lang/String;", "Lcom/discord/stores/Dispatcher;", "dispatcher", "Lcom/discord/stores/Dispatcher;", "Lcom/discord/stores/updates/ObservationDeck;", "observationDeck", "Lcom/discord/stores/updates/ObservationDeck;", "<init>", "(Lcom/discord/stores/updates/ObservationDeck;Lcom/discord/stores/Dispatcher;Lcom/discord/utilities/time/Clock;)V", "Companion", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class StoreExpressionSuggestions extends StoreV2 {
    public static final long TRACKED_EXPRESSION_SUGGESTIONS_DISPLAYED_THROTTLE_WINDOW = 60000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private String lastSuggestionTrigger;
    private long lastTrackedExpressionSuggestionsDisplayed;
    private final ObservationDeck observationDeck;
    private boolean suggestionsEnabled;

    /* compiled from: StoreExpressionSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreExpressionSuggestions$observeSuggestionsEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreExpressionSuggestions.access$getSuggestionsEnabled$p(StoreExpressionSuggestions.this);
        }
    }

    /* compiled from: StoreExpressionSuggestions.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.stores.StoreExpressionSuggestions$setExpressionSuggestionsEnabled$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $enable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$enable = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreExpressionSuggestions.access$setSuggestionsEnabled$p(StoreExpressionSuggestions.this, this.$enable);
            StoreExpressionSuggestions.this.markChanged();
        }
    }

    public /* synthetic */ StoreExpressionSuggestions(ObservationDeck observationDeck, Dispatcher dispatcher, Clock clock, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(observationDeck, dispatcher, (i & 4) != 0 ? ClockFactory.get() : clock);
    }

    public static final /* synthetic */ boolean access$getSuggestionsEnabled$p(StoreExpressionSuggestions storeExpressionSuggestions) {
        return storeExpressionSuggestions.suggestionsEnabled;
    }

    public static final /* synthetic */ void access$setSuggestionsEnabled$p(StoreExpressionSuggestions storeExpressionSuggestions, boolean z2) {
        storeExpressionSuggestions.suggestionsEnabled = z2;
    }

    public final String getLastSuggestionTrigger() {
        return this.lastSuggestionTrigger;
    }

    @Store3
    public final void handleChannelSelected() {
        this.suggestionsEnabled = true;
        markChanged();
    }

    public final Observable<Boolean> observeSuggestionsEnabled() {
        Observable<Boolean> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void setExpressionSuggestionsEnabled(boolean enable) {
        this.dispatcher.schedule(new AnonymousClass1(enable));
    }

    public final void trackExpressionSuggestionsDisplayed(String suggestionTrigger) {
        Intrinsics3.checkNotNullParameter(suggestionTrigger, "suggestionTrigger");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        if (this.lastTrackedExpressionSuggestionsDisplayed + 60000 <= jCurrentTimeMillis) {
            this.lastTrackedExpressionSuggestionsDisplayed = jCurrentTimeMillis;
            AnalyticsTracker.INSTANCE.expressionSuggestionsDisplayed(suggestionTrigger);
            this.lastSuggestionTrigger = suggestionTrigger;
        }
    }

    public StoreExpressionSuggestions(ObservationDeck observationDeck, Dispatcher dispatcher, Clock clock) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.clock = clock;
        this.suggestionsEnabled = true;
        this.lastSuggestionTrigger = "";
    }
}
