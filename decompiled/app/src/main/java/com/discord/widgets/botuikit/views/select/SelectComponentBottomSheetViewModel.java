package com.discord.widgets.botuikit.views.select;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreStream;
import d0.t.Iterables2;
import d0.t.SetsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* compiled from: SelectComponentBottomSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0011\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002BCBa\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\u0010-\u001a\u00060+j\u0002`,\u0012\u0006\u00108\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d\u0012\u0006\u00101\u001a\u00020+\u0012\u0006\u0010>\u001a\u00020+\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d\u0012\u0006\u0010<\u001a\u00020\t¢\u0006\u0004\b@\u0010AJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0010\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010#\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R:\u0010)\u001a&\u0012\f\u0012\n (*\u0004\u0018\u00010\r0\r (*\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010\r0\r\u0018\u00010'0'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001d\u0010-\u001a\u00060+j\u0002`,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00101\u001a\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\b1\u0010.\u001a\u0004\b2\u00100R\u001f\u00104\u001a\b\u0012\u0004\u0012\u00020\u0004038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0019\u00108\u001a\u00020\u00188\u0006@\u0006¢\u0006\f\n\u0004\b8\u0010\u001a\u001a\u0004\b9\u0010\u001cR\u001f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010\u001f\u001a\u0004\b;\u0010!R\u0019\u0010<\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b<\u0010\u0017\u001a\u0004\b=\u0010\u000bR\u0019\u0010>\u001a\u00020+8\u0006@\u0006¢\u0006\f\n\u0004\b>\u0010.\u001a\u0004\b?\u00100¨\u0006D"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;", "", "Lcom/discord/api/botuikit/SelectItem;", "selection", "", "sendSelectInteraction", "(Ljava/util/Set;)V", "", "isValidSelection", "()Z", "Lrx/Observable;", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;", "observeEvents", "()Lrx/Observable;", "selectItem", "selected", "(Lcom/discord/api/botuikit/SelectItem;Z)V", "onClickSelect", "()V", "updateViewState", "isMultiSelect", "Z", "", "placeholder", "Ljava/lang/String;", "getPlaceholder", "()Ljava/lang/String;", "", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Lcom/discord/widgets/botuikit/views/select/ComponentContext;", "componentContext", "Lcom/discord/widgets/botuikit/views/select/ComponentContext;", "getComponentContext", "()Lcom/discord/widgets/botuikit/views/select/ComponentContext;", "Lrx/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "eventSubject", "Lrx/subjects/PublishSubject;", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "componentIndex", "I", "getComponentIndex", "()I", "min", "getMin", "", "selectedItems", "Ljava/util/Set;", "getSelectedItems", "()Ljava/util/Set;", "customId", "getCustomId", "selectedOptions", "getSelectedOptions", "emojiAnimationsEnabled", "getEmojiAnimationsEnabled", "max", "getMax", "<init>", "(Lcom/discord/widgets/botuikit/views/select/ComponentContext;ILjava/lang/String;Ljava/lang/String;Ljava/util/List;IILjava/util/List;Z)V", "Event", "ViewState", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SelectComponentBottomSheetViewModel extends AppViewModel<ViewState> {
    private final SelectComponentBottomSheet2 componentContext;
    private final int componentIndex;
    private final String customId;
    private final boolean emojiAnimationsEnabled;
    private final PublishSubject<Event> eventSubject;
    private final boolean isMultiSelect;
    private final List<SelectComponent2> items;
    private final int max;
    private final int min;
    private final String placeholder;
    private final Set<SelectComponent2> selectedItems;
    private final List<SelectComponent2> selectedOptions;

    /* compiled from: SelectComponentBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;", "", "<init>", "()V", "CloseSheet", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event$CloseSheet;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class Event {

        /* compiled from: SelectComponentBottomSheetViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event$CloseSheet;", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$Event;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class CloseSheet extends Event {
            public static final CloseSheet INSTANCE = new CloseSheet();

            private CloseSheet() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SelectComponentBottomSheetViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000e\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0019\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013R\u0019\u0010\u001c\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001c\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetViewModel$ViewState;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "showSelectButton", "Z", "getShowSelectButton", "()Z", "emojiAnimationsEnabled", "getEmojiAnimationsEnabled", "isValidSelection", "", "minSelections", "I", "getMinSelections", "()I", "", "Lcom/discord/widgets/botuikit/views/select/SelectComponentBottomSheetItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "maxSelections", "getMaxSelections", "isMultiSelect", "<init>", "(Ljava/lang/String;Ljava/util/List;ZZIIZZ)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class ViewState {
        private final boolean emojiAnimationsEnabled;
        private final boolean isMultiSelect;
        private final boolean isValidSelection;
        private final List<SelectComponentBottomSheetAdapter2> items;
        private final int maxSelections;
        private final int minSelections;
        private final boolean showSelectButton;
        private final String title;

        public ViewState(String str, List<SelectComponentBottomSheetAdapter2> list, boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(list, "items");
            this.title = str;
            this.items = list;
            this.showSelectButton = z2;
            this.isMultiSelect = z3;
            this.minSelections = i;
            this.maxSelections = i2;
            this.isValidSelection = z4;
            this.emojiAnimationsEnabled = z5;
        }

        public final boolean getEmojiAnimationsEnabled() {
            return this.emojiAnimationsEnabled;
        }

        public final List<SelectComponentBottomSheetAdapter2> getItems() {
            return this.items;
        }

        public final int getMaxSelections() {
            return this.maxSelections;
        }

        public final int getMinSelections() {
            return this.minSelections;
        }

        public final boolean getShowSelectButton() {
            return this.showSelectButton;
        }

        public final String getTitle() {
            return this.title;
        }

        /* renamed from: isMultiSelect, reason: from getter */
        public final boolean getIsMultiSelect() {
            return this.isMultiSelect;
        }

        /* renamed from: isValidSelection, reason: from getter */
        public final boolean getIsValidSelection() {
            return this.isValidSelection;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectComponentBottomSheetViewModel(SelectComponentBottomSheet2 selectComponentBottomSheet2, int i, String str, String str2, List<SelectComponent2> list, int i2, int i3, List<SelectComponent2> list2, boolean z2) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(selectComponentBottomSheet2, "componentContext");
        Intrinsics3.checkNotNullParameter(str, "customId");
        Intrinsics3.checkNotNullParameter(list, "items");
        Intrinsics3.checkNotNullParameter(list2, "selectedOptions");
        this.componentContext = selectComponentBottomSheet2;
        this.componentIndex = i;
        this.customId = str;
        this.placeholder = str2;
        this.items = list;
        this.min = i2;
        this.max = i3;
        this.selectedOptions = list2;
        this.emojiAnimationsEnabled = z2;
        this.isMultiSelect = i3 > 1;
        this.selectedItems = _Collections.toMutableSet(list2);
        updateViewState();
        this.eventSubject = PublishSubject.k0();
    }

    private final boolean isValidSelection() {
        int i = this.min;
        int i2 = this.max;
        int size = this.selectedItems.size();
        return i <= size && i2 >= size;
    }

    private final void sendSelectInteraction(Set<SelectComponent2> selection) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getLocalActionComponentState().setSelectComponentSelection(this.componentContext.getMessageId(), this.componentIndex, _Collections.toList(selection));
        StoreApplicationInteractions interactions = companion.getInteractions();
        long applicationId = this.componentContext.getApplicationId();
        Long guildId = this.componentContext.getGuildId();
        long channelId = this.componentContext.getChannelId();
        long messageId = this.componentContext.getMessageId();
        Long messageFlags = this.componentContext.getMessageFlags();
        int i = this.componentIndex;
        String str = this.customId;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(selection, 10));
        Iterator<T> it = selection.iterator();
        while (it.hasNext()) {
            arrayList.add(((SelectComponent2) it.next()).getValue());
        }
        interactions.sendComponentInteraction(applicationId, guildId, channelId, messageId, i, new RestAPIParams.ComponentInteractionData.SelectComponentInteractionData(null, str, _Collections.toList(arrayList), 1, null), messageFlags);
        PublishSubject<Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(Event.CloseSheet.INSTANCE);
    }

    public final SelectComponentBottomSheet2 getComponentContext() {
        return this.componentContext;
    }

    public final int getComponentIndex() {
        return this.componentIndex;
    }

    public final String getCustomId() {
        return this.customId;
    }

    public final boolean getEmojiAnimationsEnabled() {
        return this.emojiAnimationsEnabled;
    }

    public final List<SelectComponent2> getItems() {
        return this.items;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final Set<SelectComponent2> getSelectedItems() {
        return this.selectedItems;
    }

    public final List<SelectComponent2> getSelectedOptions() {
        return this.selectedOptions;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onClickSelect() {
        sendSelectInteraction(_Collections.toSet(this.selectedItems));
    }

    @MainThread
    public final void selectItem(SelectComponent2 selectItem, boolean selected) {
        Intrinsics3.checkNotNullParameter(selectItem, "selectItem");
        if (!this.isMultiSelect) {
            sendSelectInteraction(SetsJVM.setOf(selectItem));
            return;
        }
        if (selected) {
            this.selectedItems.add(selectItem);
        } else {
            this.selectedItems.remove(selectItem);
        }
        updateViewState();
    }

    public final void updateViewState() {
        String str = this.placeholder;
        List<SelectComponent2> list = this.items;
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        for (SelectComponent2 selectComponent2 : list) {
            arrayList.add(new SelectComponentBottomSheetAdapter2(selectComponent2, this.selectedItems.contains(selectComponent2)));
        }
        updateViewState(new ViewState(str, arrayList, this.isMultiSelect, this.isMultiSelect, this.min, this.max, isValidSelection(), this.emojiAnimationsEnabled));
    }
}
