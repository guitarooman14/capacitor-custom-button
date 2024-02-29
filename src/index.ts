import { registerPlugin } from '@capacitor/core';

import type { CustomButtonPlugin } from './definitions';

const CustomButton = registerPlugin<CustomButtonPlugin>(
  'CustomButton',
  {
    web: () => import('./web').then(m => new m.CustomButtonWeb()),
  },
);

export * from './definitions';
export { CustomButton };
