package com.discord.widgets.voice.sheet;

import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR:\u0010\u000f\u001a&\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004 \u000e*\u0012\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\r0\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$ViewState;", "Lrx/Observable;", "Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "", "onNoiseCancellationButtonPressed", "()V", "Lcom/discord/stores/StoreMediaSettings;", "mediaSettingsStore", "Lcom/discord/stores/StoreMediaSettings;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "<init>", "(Lcom/discord/stores/StoreMediaSettings;)V", "Event", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class WidgetNoiseCancellationBottomSheetViewModel extends AppViewModel<ViewState> {
    private final PublishSubject<Event> eventSubject;
    private final StoreMediaSettings mediaSettingsStore;

    /* compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event;", "", "<init>", "()V", "ShowToast", "Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0003\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\u0004J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast;", "Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event;", "", "component1", "()I", "toastResId", "copy", "(I)Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$Event$ShowToast;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getToastResId", "<init>", "(I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class ShowToast extends Event {
            private final int toastResId;

            public ShowToast(@StringRes int i) {
                super(null);
                this.toastResId = i;
            }

            public static /* synthetic */ ShowToast copy$default(ShowToast showToast, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = showToast.toastResId;
                }
                return showToast.copy(i);
            }

            /* renamed from: component1, reason: from getter */
            public final int getToastResId() {
                return this.toastResId;
            }

            public final ShowToast copy(@StringRes int toastResId) {
                return new ShowToast(toastResId);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ShowToast) && this.toastResId == ((ShowToast) other).toastResId;
                }
                return true;
            }

            public final int getToastResId() {
                return this.toastResId;
            }

            public int hashCode() {
                return this.toastResId;
            }

            public String toString() {
                return outline.B(outline.U("ShowToast(toastResId="), this.toastResId, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetNoiseCancellationBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b6\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/voice/sheet/WidgetNoiseCancellationBottomSheetViewModel$ViewState;", "", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class ViewState {
        private ViewState() {
        }
    }

    public WidgetNoiseCancellationBottomSheetViewModel() {
        this(null, 1, null);
    }

    public /* synthetic */ WidgetNoiseCancellationBottomSheetViewModel(StoreMediaSettings storeMediaSettings, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.INSTANCE.getMediaSettings() : storeMediaSettings);
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void onNoiseCancellationButtonPressed() {
        this.mediaSettingsStore.setVoiceConfiguration(StoreMediaSettings.NoiseProcessing.Cancellation);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new Event.ShowToast(R.string.noise_cancellation_on));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNoiseCancellationBottomSheetViewModel(StoreMediaSettings storeMediaSettings) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        this.mediaSettingsStore = storeMediaSettings;
        this.eventSubject = PublishSubject.k0();
    }
}
