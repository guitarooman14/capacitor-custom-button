> [!IMPORTANT]  
> This repository has been merged into [@capacitor-community/volume-buttons](https://github.com/capacitor-community/volume-buttons), where is it going to be actively maintained

# capacitor-volume-buttons

Hardware volume buttons listener for Capacitor

## Install

```bash
npm install capacitor-custom-button
npx cap sync
```

## Quick example
```tsx
  useEffect(() => {
    const onCustomButtonPressed = ({ isLongPress }: CustomButtonPressed) => {
      console.log(key);
    };

    const listener = CustomButton.addListener('customButtonPressed', onCustomButtonPressed);

    return () => {
      listener.remove();
    };
  }, []);
```

## API

<docgen-index>

* [`addListener('pttButtonPressed', ...)`](#addlistenerpttbuttonpressed-)
* [`addListener('headsetButtonPressed', ...)`](#addlistenerheadsetbuttonpressed-)
* [`removeAllListeners()`](#removealllisteners)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### addListener('pttButtonPressed', ...)

```typescript
addListener(event: 'pttButtonPressed', listenerFunc: PttButtonPressedListener) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listen for presses on the hardware CUSTOM PTT button

| Param              | Type                                                                          |
| ------------------ | ----------------------------------------------------------------------------- |
| **`event`**        | <code>'pttButtonPressed'</code>                                               |
| **`listenerFunc`** | <code><a href="#pttbuttonpressedlistener">PttButtonPressedListener</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

**Since:** 1.0.0

--------------------


### addListener('headsetButtonPressed', ...)

```typescript
addListener(event: 'headsetButtonPressed', listenerFunc: HeadsetButtonPressedListener) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listen for presses on the hardware HEADSET PTT button

| Param              | Type                                                                                  |
| ------------------ | ------------------------------------------------------------------------------------- |
| **`event`**        | <code>'headsetButtonPressed'</code>                                                   |
| **`listenerFunc`** | <code><a href="#headsetbuttonpressedlistener">HeadsetButtonPressedListener</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

**Since:** 1.0.0

--------------------


### removeAllListeners()

```typescript
removeAllListeners() => Promise<void>
```

Removes all listeners for this plugin

**Since:** 1.0.0

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |


### Type Aliases


#### PttButtonPressedListener

<code>({ isLongPress }: <a href="#pttbuttonpressed">PttButtonPressed</a>): void</code>


#### PttButtonPressed

<code>{ isLongPress: boolean }</code>


#### HeadsetButtonPressedListener

<code>({ isLongPress }: <a href="#headsetbuttonpressed">HeadSetButtonPressed</a>): void</code>


#### HeadSetButtonPressed

<code>{ isLongPress: boolean }</code>

</docgen-api>
