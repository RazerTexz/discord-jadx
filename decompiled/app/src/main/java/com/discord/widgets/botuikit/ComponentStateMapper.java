package com.discord.widgets.botuikit;

import b.d.b.a.outline;
import com.discord.api.botuikit.ActionRowComponent;
import com.discord.api.botuikit.ButtonComponent;
import com.discord.api.botuikit.Component;
import com.discord.api.botuikit.Component5;
import com.discord.api.botuikit.Component7;
import com.discord.api.botuikit.Component8;
import com.discord.api.botuikit.SelectComponent;
import com.discord.models.botuikit.ActionInteractionComponentState;
import com.discord.models.botuikit.ActionRowMessageComponent2;
import com.discord.models.botuikit.ButtonMessageComponent2;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.botuikit.SelectMessageComponent2;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.widgets.botuikit.ComponentChatListState;
import d0.t._Arrays;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ComponentStateMapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ;\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J9\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00172\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/discord/widgets/botuikit/ComponentStateMapper;", "", "", "Lcom/discord/api/botuikit/Component;", "apiComponents", "Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;", "componentStoreState", "Lcom/discord/widgets/botuikit/ComponentExperiments;", "componentExperiments", "", "animateEmojis", "Lcom/discord/models/botuikit/MessageComponent;", "processComponentsToMessageComponents", "(Ljava/util/List;Lcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;Lcom/discord/widgets/botuikit/ComponentExperiments;Z)Ljava/util/List;", "Lcom/discord/api/botuikit/ActionComponent;", "component", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "index", "storeState", "experimentController", "createActionMessageComponent", "(Lcom/discord/api/botuikit/ActionComponent;ILcom/discord/widgets/botuikit/ComponentChatListState$ComponentStoreState;Lcom/discord/widgets/botuikit/ComponentExperiments;)Lcom/discord/models/botuikit/MessageComponent;", "Lcom/discord/api/botuikit/LayoutComponent;", "children", "toMessageLayoutComponent", "(Lcom/discord/api/botuikit/LayoutComponent;ILjava/util/List;Lcom/discord/widgets/botuikit/ComponentExperiments;)Lcom/discord/models/botuikit/MessageComponent;", "<init>", "()V", "ChildComponents", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class ComponentStateMapper {
    public static final ComponentStateMapper INSTANCE = new ComponentStateMapper();

    /* compiled from: ComponentStateMapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "i", "Lcom/discord/api/botuikit/Component;", "component", "", "invoke", "(ILcom/discord/api/botuikit/Component;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.botuikit.ComponentStateMapper$processComponentsToMessageComponents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<Integer, Component, Unit> {
        public final /* synthetic */ Stack $childComponentsLevelStack;
        public final /* synthetic */ Ref$ObjectRef $childrenComponents;
        public final /* synthetic */ ComponentExperiments $componentExperiments;
        public final /* synthetic */ ComponentChatListState.ComponentStoreState $componentState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ComponentChatListState.ComponentStoreState componentStoreState, ComponentExperiments componentExperiments, Ref$ObjectRef ref$ObjectRef, Stack stack) {
            super(2);
            this.$componentState = componentStoreState;
            this.$componentExperiments = componentExperiments;
            this.$childrenComponents = ref$ObjectRef;
            this.$childComponentsLevelStack = stack;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Component component) {
            invoke(num.intValue(), component);
            return Unit.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [T, com.discord.widgets.botuikit.ComponentStateMapper$ChildComponents] */
        /* JADX WARN: Type inference failed for: r8v0, types: [T, com.discord.widgets.botuikit.ComponentStateMapper$ChildComponents] */
        public final void invoke(int i, Component component) {
            Component8 parentLayoutComponent;
            Intrinsics3.checkNotNullParameter(component, "component");
            if (component instanceof Component5) {
                MessageComponent messageComponentCreateActionMessageComponent = ComponentStateMapper.INSTANCE.createActionMessageComponent((Component5) component, i, this.$componentState, this.$componentExperiments);
                if (messageComponentCreateActionMessageComponent != null) {
                    ((ChildComponents) this.$childrenComponents.element).getComponents()[((ChildComponents) this.$childrenComponents.element).getCurrentComponentInsertionIndex()] = messageComponentCreateActionMessageComponent;
                }
                ChildComponents childComponents = (ChildComponents) this.$childrenComponents.element;
                childComponents.setCurrentComponentInsertionIndex(childComponents.getCurrentComponentInsertionIndex() + 1);
            } else if (component instanceof Component8) {
                this.$childComponentsLevelStack.push((ChildComponents) this.$childrenComponents.element);
                Component8 component8 = (Component8) component;
                this.$childrenComponents.element = new ChildComponents(i, component8, 0, component8.a().size(), 4, null);
            }
            while (((ChildComponents) this.$childrenComponents.element).getCurrentComponentInsertionIndex() == ((ChildComponents) this.$childrenComponents.element).getTotal() && (parentLayoutComponent = ((ChildComponents) this.$childrenComponents.element).getParentLayoutComponent()) != null) {
                MessageComponent messageLayoutComponent = ComponentStateMapper.INSTANCE.toMessageLayoutComponent(parentLayoutComponent, ((ChildComponents) this.$childrenComponents.element).getLayoutComponentIndex(), _Arrays.filterNotNull(((ChildComponents) this.$childrenComponents.element).getComponents()), this.$componentExperiments);
                Ref$ObjectRef ref$ObjectRef = this.$childrenComponents;
                Object objPop = this.$childComponentsLevelStack.pop();
                Intrinsics3.checkNotNullExpressionValue(objPop, "childComponentsLevelStack.pop()");
                ref$ObjectRef.element = (ChildComponents) objPop;
                ((ChildComponents) this.$childrenComponents.element).getComponents()[((ChildComponents) this.$childrenComponents.element).getCurrentComponentInsertionIndex()] = messageLayoutComponent;
                ChildComponents childComponents2 = (ChildComponents) this.$childrenComponents.element;
                childComponents2.setCurrentComponentInsertionIndex(childComponents2.getCurrentComponentInsertionIndex() + 1);
            }
        }
    }

    private ComponentStateMapper() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MessageComponent createActionMessageComponent(Component5 component, int index, ComponentChatListState.ComponentStoreState storeState, ComponentExperiments experimentController) {
        Integer num;
        Set<Map.Entry<Integer, StoreApplicationInteractions.InteractionSendState>> setEntrySet;
        Object next;
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        Intrinsics3.checkNotNullParameter(experimentController, "experimentController");
        if (!experimentController.isEnabled(component.getType())) {
            return null;
        }
        Map<Integer, StoreApplicationInteractions.InteractionSendState> interactionState = storeState.getInteractionState();
        if (interactionState == null || (setEntrySet = interactionState.entrySet()) == null) {
            num = null;
        } else {
            Iterator<T> it = setEntrySet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((Map.Entry) next).getValue() instanceof StoreApplicationInteractions.InteractionSendState.Loading) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                num = (Integer) entry.getKey();
            }
        }
        Map<Integer, StoreApplicationInteractions.InteractionSendState> interactionState2 = storeState.getInteractionState();
        StoreApplicationInteractions.InteractionSendState interactionSendState = interactionState2 != null ? interactionState2.get(Integer.valueOf(index)) : null;
        if (!(interactionSendState instanceof StoreApplicationInteractions.InteractionSendState.Failed)) {
            interactionSendState = null;
        }
        StoreApplicationInteractions.InteractionSendState.Failed failed = (StoreApplicationInteractions.InteractionSendState.Failed) interactionSendState;
        ActionInteractionComponentState failed2 = (num != null && index == num.intValue()) ? ActionInteractionComponentState.Loading.INSTANCE : (num == null || num.intValue() == index) ? failed != null ? new ActionInteractionComponentState.Failed(failed.getErrorMessage()) : ActionInteractionComponentState.Enabled.INSTANCE : ActionInteractionComponentState.Disabled.INSTANCE;
        if (component instanceof ButtonComponent) {
            return ButtonMessageComponent2.mergeToMessageComponent((ButtonComponent) component, index, failed2, storeState);
        }
        if (component instanceof SelectComponent) {
            return SelectMessageComponent2.mergeToMessageComponent((SelectComponent) component, index, failed2, storeState);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [T, com.discord.widgets.botuikit.ComponentStateMapper$ChildComponents] */
    public final List<MessageComponent> processComponentsToMessageComponents(List<? extends Component> apiComponents, ComponentChatListState.ComponentStoreState componentStoreState, ComponentExperiments componentExperiments, boolean animateEmojis) {
        Intrinsics3.checkNotNullParameter(apiComponents, "apiComponents");
        Intrinsics3.checkNotNullParameter(componentExperiments, "componentExperiments");
        if (componentStoreState == null) {
            componentStoreState = new ComponentChatListState.ComponentStoreState(null, null, animateEmojis, 3, null);
        }
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new ChildComponents(-1, null, 0, apiComponents.size());
        Stack stack = new Stack();
        Component7 component7 = Component7.INSTANCE;
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(componentStoreState, componentExperiments, ref$ObjectRef, stack);
        Objects.requireNonNull(component7);
        Intrinsics3.checkNotNullParameter(apiComponents, "$this$forEachComponentIndexed");
        Intrinsics3.checkNotNullParameter(anonymousClass1, "action");
        component7.a(apiComponents, 0, anonymousClass1);
        return _Arrays.filterNotNull(((ChildComponents) ref$ObjectRef.element).getComponents());
    }

    public final MessageComponent toMessageLayoutComponent(Component8 component, int index, List<? extends MessageComponent> children, ComponentExperiments experimentController) {
        Intrinsics3.checkNotNullParameter(component, "component");
        Intrinsics3.checkNotNullParameter(children, "children");
        Intrinsics3.checkNotNullParameter(experimentController, "experimentController");
        ActionRowComponent actionRowComponent = (ActionRowComponent) component;
        if (experimentController.isEnabled(actionRowComponent.getType())) {
            return ActionRowMessageComponent2.mergeToMessageComponent(actionRowComponent, index, children);
        }
        return null;
    }

    /* compiled from: ComponentStateMapper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0014\u0010\t\u001a\u00060\u0002j\u0002`\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0005JB\u0010\u000f\u001a\u00020\u00002\f\b\u0002\u0010\u000b\u001a\u00060\u0002j\u0002`\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\f\b\u0002\u0010\r\u001a\u00060\u0002j\u0002`\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0005J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R&\u0010\r\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005\"\u0004\b\u001b\u0010\u001cR!\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0019\u0010\u000e\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0019\u001a\u0004\b#\u0010\u0005R\u001d\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b$\u0010\u0005R\u001b\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010%\u001a\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lcom/discord/widgets/botuikit/ComponentStateMapper$ChildComponents;", "", "", "Lcom/discord/widgets/botuikit/ComponentIndex;", "component1", "()I", "Lcom/discord/api/botuikit/LayoutComponent;", "component2", "()Lcom/discord/api/botuikit/LayoutComponent;", "component3", "component4", "layoutComponentIndex", "parentLayoutComponent", "currentComponentInsertionIndex", "total", "copy", "(ILcom/discord/api/botuikit/LayoutComponent;II)Lcom/discord/widgets/botuikit/ComponentStateMapper$ChildComponents;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getCurrentComponentInsertionIndex", "setCurrentComponentInsertionIndex", "(I)V", "", "Lcom/discord/models/botuikit/MessageComponent;", "components", "[Lcom/discord/models/botuikit/MessageComponent;", "getComponents", "()[Lcom/discord/models/botuikit/MessageComponent;", "getTotal", "getLayoutComponentIndex", "Lcom/discord/api/botuikit/LayoutComponent;", "getParentLayoutComponent", "<init>", "(ILcom/discord/api/botuikit/LayoutComponent;II)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class ChildComponents {
        private final MessageComponent[] components;
        private int currentComponentInsertionIndex;
        private final int layoutComponentIndex;
        private final Component8 parentLayoutComponent;
        private final int total;

        public ChildComponents(int i, Component8 component8, int i2, int i3) {
            this.layoutComponentIndex = i;
            this.parentLayoutComponent = component8;
            this.currentComponentInsertionIndex = i2;
            this.total = i3;
            MessageComponent[] messageComponentArr = new MessageComponent[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                messageComponentArr[i4] = null;
            }
            this.components = messageComponentArr;
        }

        public static /* synthetic */ ChildComponents copy$default(ChildComponents childComponents, int i, Component8 component8, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = childComponents.layoutComponentIndex;
            }
            if ((i4 & 2) != 0) {
                component8 = childComponents.parentLayoutComponent;
            }
            if ((i4 & 4) != 0) {
                i2 = childComponents.currentComponentInsertionIndex;
            }
            if ((i4 & 8) != 0) {
                i3 = childComponents.total;
            }
            return childComponents.copy(i, component8, i2, i3);
        }

        /* renamed from: component1, reason: from getter */
        public final int getLayoutComponentIndex() {
            return this.layoutComponentIndex;
        }

        /* renamed from: component2, reason: from getter */
        public final Component8 getParentLayoutComponent() {
            return this.parentLayoutComponent;
        }

        /* renamed from: component3, reason: from getter */
        public final int getCurrentComponentInsertionIndex() {
            return this.currentComponentInsertionIndex;
        }

        /* renamed from: component4, reason: from getter */
        public final int getTotal() {
            return this.total;
        }

        public final ChildComponents copy(int layoutComponentIndex, Component8 parentLayoutComponent, int currentComponentInsertionIndex, int total) {
            return new ChildComponents(layoutComponentIndex, parentLayoutComponent, currentComponentInsertionIndex, total);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChildComponents)) {
                return false;
            }
            ChildComponents childComponents = (ChildComponents) other;
            return this.layoutComponentIndex == childComponents.layoutComponentIndex && Intrinsics3.areEqual(this.parentLayoutComponent, childComponents.parentLayoutComponent) && this.currentComponentInsertionIndex == childComponents.currentComponentInsertionIndex && this.total == childComponents.total;
        }

        public final MessageComponent[] getComponents() {
            return this.components;
        }

        public final int getCurrentComponentInsertionIndex() {
            return this.currentComponentInsertionIndex;
        }

        public final int getLayoutComponentIndex() {
            return this.layoutComponentIndex;
        }

        public final Component8 getParentLayoutComponent() {
            return this.parentLayoutComponent;
        }

        public final int getTotal() {
            return this.total;
        }

        public int hashCode() {
            int i = this.layoutComponentIndex * 31;
            Component8 component8 = this.parentLayoutComponent;
            return ((((i + (component8 != null ? component8.hashCode() : 0)) * 31) + this.currentComponentInsertionIndex) * 31) + this.total;
        }

        public final void setCurrentComponentInsertionIndex(int i) {
            this.currentComponentInsertionIndex = i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChildComponents(layoutComponentIndex=");
            sbU.append(this.layoutComponentIndex);
            sbU.append(", parentLayoutComponent=");
            sbU.append(this.parentLayoutComponent);
            sbU.append(", currentComponentInsertionIndex=");
            sbU.append(this.currentComponentInsertionIndex);
            sbU.append(", total=");
            return outline.B(sbU, this.total, ")");
        }

        public /* synthetic */ ChildComponents(int i, Component8 component8, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i4 & 2) != 0 ? null : component8, (i4 & 4) != 0 ? 0 : i2, i3);
        }
    }
}
